#!/bin/bash

# -------------------------------------------------------------------------
# Demo Bootstrap Script for Linux
# -------------------------------------------------------------------------

# 从JAVA_HOME或PATH获取JAVA运行命令
getJava() {
  if [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]];  then
    echo "$JAVA_HOME/bin/java"
  else
    echo "java"
  fi
}

# 获取JAVA的版本
getJavaVersion() {
    echo "$("$(getJava)" -version 2>&1 | awk -F '"' '/version/ {print $2}')"
}

# 获取内存参数
getMemOpts () {
  local mem=${1:-1024}
  local meta=$(( $mem / 4 ))
  (( $meta > 256 )) || meta=256
  (( $meta < 1024 )) || meta=1024

  # default is to set memory options but this can be overridden by code section below
  memopts="-Xms${mem}m -Xmx${mem}m"
  if [[ "$(getJavaVersion)" > "1.8" ]]; then
    extmemopts="-XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=${meta}m"
  else
    extmemopts="-XX:PermSize=64m -XX:MaxPermSize=${meta}m"
  fi

  if [[ "${JAVA_OPTS}" == *-Xmx* ]] || [[ "${JAVA_OPTS}" == *-Xms* ]] || [[ "${JAVA_OPTS}" == *-XX:MaxPermSize* ]] || [[ "${JAVA_OPTS}" == *-XX:ReservedCodeCacheSize* ]] || [[ "${JAVA_OPTS}" == *-XX:MaxMetaspaceSize* ]]; then
    memopts=""
    extmemopts=""
  fi

  echo "${memopts} ${extmemopts}"
}

# 获取CLASSPATH
getClassPath() {
    local classPath="${APP_HOME}/conf"
    for i in ${APP_HOME}/lib/*; do
      classPath="${classPath}:${i}"
    done

    echo "${classPath}"
}

APP_HOME=`dirname $0`
APP_HOME=`cd ${APP_HOME}; pwd`
APP_LAUNCHER="com.feng.web.App"

if [ -z $APP_PID_FILE ]; then
    APP_PID_FILE="$APP_HOME/app.pid"
fi

APP_LOG_DIR="$APP_HOME/logs"

if [ ! -w "$APP_LOG_DIR" ] ; then
    mkdir -p "$APP_LOG_DIR"
fi

_APP_DAEMON_OUT="$APP_LOG_DIR/app.out"

JAVA=$(getJava)
JAVA_OPTS="$(getMemOpts) $JAVA_OPTS"

case $1 in
generateDTCode)
    echo -e "==================== Demo Running ... ===================="
    $JAVA ${JAVA_OPTS} "-Dapp.home=${APP_HOME}" "-Djava.library.path=${APP_HOME}/native" "-Djava.net.preferIPv4Stack=true" -classpath "$(getClassPath)" $APP_LAUNCHER generateDTCodes
    ;;
run)
    echo -e "==================== Demo Running ... ===================="
    echo -e ""
    $JAVA ${JAVA_OPTS} "-Dapp.home=${APP_HOME}" "-Djava.library.path=${APP_HOME}/native" "-Djava.net.preferIPv4Stack=true" -classpath "$(getClassPath)" $APP_LAUNCHER
    ;;
start)
    echo  -e "==================== Demo Starting ... ===================="
    if [ -f $APP_PID_FILE ]; then
      if kill -0 `cat $APP_PID_FILE` > /dev/null 2>&1; then
         echo $command already running as process `cat $APP_PID_FILE`.
         exit 0
      fi
    fi

    nohup $JAVA ${JAVA_OPTS} "-Dapp.home=${APP_HOME}" "-Djava.library.path=${APP_HOME}/native" "-Djava.net.preferIPv4Stack=true" -classpath "$(getClassPath)" $APP_LAUNCHER > "$_APP_DAEMON_OUT" 2>&1 < /dev/null &

    if [ $? -eq 0 ]
    then
      if /bin/echo -n $! > "$APP_PID_FILE"
      then
        sleep 1
        echo STARTED
      else
        echo FAILED TO WRITE PID
        exit 1
      fi
    else
      echo SERVER DID NOT START
      exit 1
    fi
    ;;
stop)
    echo -e "==================== Demo Stopping ... ===================="
    if [ ! -f "$APP_PID_FILE" ]
    then
      echo "no app to stop (could not find file $APP_PID_FILE)"
    else
      kill $(cat "$APP_PID_FILE")
      rm "$APP_PID_FILE"
      echo STOPPED
    fi
    exit 0
    ;;
restart)
    shift
    "$0" stop ${@}
    sleep 10
    "$0" start ${@}
    ;;
*)
    echo "Usage: $0 {generateDTCode|run|start|stop|restart}" >&2

esac
