### Build

```bash
buildah bud -t ghcr.io/ngmaibulat/tcping-kaniko:latest .

echo "${{ secrets.GITHUB_TOKEN }}" | docker login ghcr.io -u $ --password-stdin

echo $GH_TOKEN | podman login ghcr.io -u $ --password-stdin
```
