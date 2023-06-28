./gradlew build

rm -fr install
mkdir install

cp build/libs/tcpping-all.jar install/tcpping.jar

# jpackage --type app-image --input build/libs --main-jar tcpping.jar --name tcpping
# jpackage --type dmg --input build/libs --main-jar tcpping.jar --name tcpping
jpackage --type pkg --input install --main-jar tcpping.jar --name tcpping --app-version 1.0.0
mv tcpping-*.pkg install/

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
