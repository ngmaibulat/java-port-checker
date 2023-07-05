### TCP Ping

```
Check if outbound tcp connection is allowed via connection to portquiz.net
```

### Install

-   For Macos, use the \*.pkg file in `install` folder here

### Set Path

```bash
export PATH="/Applications/tcpping.app/Contents/MacOS:$PATH"
```

### Customize ENV

```bash
export PORTCHECKER_HOST="microsoft.com"
export PORTCHECKER_PORT="443"
export PORTCHECKER_TIMEOUT_MS="7000"
env | grep PORTCHECKER
```

### Executables

-   https://ngm-dev-s3.s3.eu-central-1.amazonaws.com/tcpping-2023-07-05/linux/tcpping-linux
-   https://ngm-dev-s3.s3.eu-central-1.amazonaws.com/tcpping-2023-07-05/macos/tcpping-macos

### Run via CLI

```bash
tcpping
tcpping 443
```

### Run via Docker

```bash
docker run ghcr.io/ngmaibulat/tcping
docker run ghcr.io/ngmaibulat/tcping 443
```

### Use alias for Docker command

```bash
# create alias
alias tcping='docker run ghcr.io/ngmaibulat/tcping'

# add alias to bashrc and/or zshrc
echo "alias tcping='docker run ghcr.io/ngmaibulat/tcping'" >> ~/.bashrc
echo "alias tcping='docker run ghcr.io/ngmaibulat/tcping'" >> ~/.zshrc

# reload bashrc and/or zshrc
source ~/.bashrc
source ~/.zshrc

# use
tcping
tcping 443
```

### Check connectivity to Forcepoint Cloud Web Security

```bash
docker run ghcr.io/ngmaibulat/tcping 8081
docker run ghcr.io/ngmaibulat/tcping 8082
```

### Other Options

```bash
nc -vz portquiz.net 443
```

### Also look at

-   https://ifconfig.me/
-   https://www.portquiz.net/
-   https://www.wormly.com/test-smtp-server
