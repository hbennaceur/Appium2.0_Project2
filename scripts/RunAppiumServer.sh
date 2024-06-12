#!/bin/bash
set -ex

# Install Node.js and Appium
curl -fsSL https://deb.nodesource.com/setup_17.x | sudo -E bash -
sudo apt-get install -y nodejs
sudo npm install -g appium

# Install uiautomator2 driver
sudo npm install -g appium-uiautomator2-driver

# Start Appium server
appium -v
appium --log appium.log &>/dev/null &
