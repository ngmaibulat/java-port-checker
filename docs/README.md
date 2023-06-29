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

### Run via CLI

```bash
tcpping
tcpping 443
```

### Run via Docker

```bash
docker run ngmaibulat/tcpping
docker run ngmaibulat/tcpping 443
```

### Other Options

```bash
nc -vz portquiz.net 443
```

### Also look at

-   https://ifconfig.me/
-   https://www.portquiz.net/
