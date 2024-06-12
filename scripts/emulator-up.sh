#!/bin/bash
#using shebang with -i to enable interactive mode (auto load .bashrc)

set -e #stop immediately if any error happens

avd_name=$1

if [[ -z "$avd_name" ]]; then
  avd_name="avd28"
fi

# Check if emulator works well
emulator -version

# Create virtual device, default using Android 9 Pie image (API Level 28)
echo no | avdmanager create avd -n avd28 -k "system-images;android-28;google_apis;x86_64"

# Start the emulator
emulator -avd avd28 -no-audio -no-window -no-accel &

# Show connected virtual device
adb devices
