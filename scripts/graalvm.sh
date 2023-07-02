
if grep -q "Ubuntu" /etc/os-release; then
    echo "Found: Ubuntu"
    sudo apt -y install unzip zip
fi


curl -s "https://get.sdkman.io" | bash 

source ~/.sdkman/bin/sdkman-init.sh

sdk list java

sdk install java 20.0.1-open

sdk install java 21.ea.28-open

sdk install java 20.0.1-graal

sdk use java 20.0.1-open

sdk use java 21.ea.28-open

sdk use java 20.0.1-graal

which java
which native-image
