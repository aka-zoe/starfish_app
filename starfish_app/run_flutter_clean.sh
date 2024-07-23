#!/bin/bash

# 第一步：删除当前目录下的pubspec.lock文件
if [ -f pubspec.lock ]; then
    rm pubspec.lock
    echo "已删除pubspec.lock文件"
else
    echo "pubspec.lock文件不存在"
fi

# 第二步：执行flutter clean命令
flutter clean
echo "已执行flutter clean"

# 第三步：执行flutter pub upgrade命令
flutter pub upgrade
echo "已执行flutter pub upgrade"
