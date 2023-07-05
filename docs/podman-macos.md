### Install

```bash

brew install podman

podman machine init
podman machine start

podman info

export DOCKER_HOST="unix:///Users/$USER/.local/share/containers/podman/machine/qemu/podman.sock"
echo $DOCKER_HOST
docker ps
```
