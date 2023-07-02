### Install GraalVM

```bash
mkdir -p ~/tmp

cd ~/tmp

rm -fr graal*

wget https://download.oracle.com/graalvm/20/latest/graalvm-jdk-20_macos-x64_bin.tar.gz

tar -xvf graalvm-jdk-20_macos-x64_bin.tar.gz
rm -f *.tar.gz

sudo xattr -r -d com.apple.quarantine graalvm-jdk-*
```

### Test

```bash
./graalvm-jdk-20.0.1+9.1/Contents/Home/bin/native-image --version
```

### Move

```bash
sudo mv graalvm-jdk-* /Library/Java/JavaVirtualMachines

/usr/libexec/java_home -V
```

### ENV

```bash
export PATH=/Library/Java/JavaVirtualMachines/graalvm-jdk-20.0.1+9.1/Contents/Home/bin:$PATH
export JAVA_HOME=/Library/Java/JavaVirtualMachines/graalvm-jdk-20.0.1+9.1/Contents/Home
```

### CleanUP

```bash
cd
rm -fr mkdir -p ~/tmp
```

### Use GraalVM

```bash
cd install-macos
native-image -jar tcpping.jar
native-image -jar tcpping.jar --no-fallback -H:+BuildReport -H:Name=tcpping-macos
```

### Another sample

-   https://blogs.oracle.com/developers/post/building-cross-platform-native-images-with-graalvm

```bash
native-image \
    --no-server \
    --no-fallback \
    -H:ReflectionConfigurationResources=reflection-config.json \
    -H:IncludeResources=logback.xml \
    --allow-incomplete-classpath \
    -jar build/libs/simple-socket-fn-logger-1.0.0-all.jar
```

### Unsupported/Limited Features

-   dynamic loading of code
-   reflection
-   deserialization
