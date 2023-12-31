./gradlew build

rm -fr install-macos
mkdir install-macos

cp build/libs/tcpping-all.jar install-macos/tcpping.jar

# jpackage --type app-image --input build/libs --main-jar tcpping.jar --name tcpping
# jpackage --type dmg --input build/libs --main-jar tcpping.jar --name tcpping
jpackage --type pkg --input install-macos --main-jar tcpping.jar --name tcpping --app-version 1.0.3
mv tcpping-*.pkg install-macos/

cd install-macos
native-image -jar tcpping.jar --no-fallback -H:+BuildReport -H:Name=tcpping-macos

# hdiutil create -format UDZO -srcfolder tcpping.app tcpping.dmg

# jpackage --input target/ \
#   --name MyAppName \
#   --main-jar MyAppName.jar \
#   --main-class com.codetinkering.app.MyMain \
#   --type dmg \
#   --icon "/user/home/myiconfile.icns" \
#   --app-version "1.2.3" \
#   --vendor "code tinkering" \
#   --copyright "Copyright 2020 whoever" \
#   --mac-package-name "App Name in Menu" \
#   --module-path "/opt/javafx/javafx-sdk-14.0.1/lib" \
#   --add-modules javafx.controls \
#  #--mac-sign \
#  #--mac-bundle-identifier "MyAppName-1.2.3" \
#  #--mac-bundle-name "My App Name" \
#  #--mac-bundle-signing-prefix "" \
#  #--mac-signing-keychain "" \
#  #--mac-signing-key-user-name "" \
#   --verbose \
#   --java-options '--enable-preview'
