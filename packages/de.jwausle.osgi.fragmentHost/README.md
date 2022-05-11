# Only Fragment host

```
g! fgm
bundle://1cf6b07d-3bb5-4de4-9b01-4bd6a2daec8d_7.0:0/folder/file.txt
Fragment Host file.txt
--------------------------------------------------
bundle://1cf6b07d-3bb5-4de4-9b01-4bd6a2daec8d_7.0:1/folder/file.txt
Fragment Host file.txt

```

## With Fragment host

> add runbundles: de.jwausle.osgi.fragmentBundle

```
g! fgm
bundle://f6b08c47-9953-4d2c-8516-1f9494222f33_8.0:0/folder/file.txt
Fragment Host file.txt
bundle://f6b08c47-9953-4d2c-8516-1f9494222f33_7.0:0/folder/file.txt
Fragment Bundle file.txt
--------------------------------------------------
bundle://f6b08c47-9953-4d2c-8516-1f9494222f33_8.0:1/folder/file.txt
Fragment Host file.txt
bundle://f6b08c47-9953-4d2c-8516-1f9494222f33_8.0:2/folder/file.txt
Fragment Bundle file.txt
```