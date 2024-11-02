# Only Fragment host

Fragment host and bundle provide the same file `folder/file.txt` and 2 commands

* `fgm` from host to show all context:folder/file.txt
* `fgm2` from bundle with the same impl

> Run: bndrun-host-only.bndrun

```
g! fgm
--------------------------------------------------
Bundle context: org.apache.felix.framework.BundleContextImpl@47542153
--------------------------------------------------
bundle://00d0f255-ff5f-457b-98af-031555ccb0d2_7.0:0/folder/file.txt
Fragment Host file.txt
--------------------------------------------------
bundle://00d0f255-ff5f-457b-98af-031555ccb0d2_7.0:1/folder/file.txt
Fragment Host file.txt

g! cat bundle://00d0f255-ff5f-457b-98af-031555ccb0d2_7.0:0/folder/file.txt

g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.fragmentHost [7] provides:
------------------------------------------
osgi.wiring.package [EMPTY]
```

## With Fragment host

> Run: bndrun-host-with-fragment.bndrun

```
g! fgm
--------------------------------------------------
Bundle context: org.apache.felix.framework.BundleContextImpl@71b1176b
--------------------------------------------------
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:0/folder/file.txt
Fragment Host file.txt
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_8.0:0/folder/file.txt
Fragment Bundle file.txt
--------------------------------------------------
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:1/folder/file.txt
Fragment Host file.txt
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:2/folder/file.txt
Fragment Bundle file.txt

g! fgm2
--------------------------------------------------
Fragment context: org.apache.felix.framework.BundleContextImpl@71b1176b
--------------------------------------------------
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:0/folder/file.txt
Fragment Host file.txt
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_8.0:0/folder/file.txt
Fragment Bundle file.txt
--------------------------------------------------
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:1/folder/file.txt
Fragment Host file.txt
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:2/folder/file.txt
Fragment Bundle file.txt
```

> Same bundle context == fragment context !!

## Fragment bundle can export packages and provide DS

```
g! inspect cap osgi.wiring.package 8
de.jwausle.osgi.fragmentBundle [8] provides:
--------------------------------------------
osgi.wiring.package [EMPTY]

g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.fragmentHost [7] provides:
------------------------------------------
osgi.wiring.package; de.jwausle.osgi.fragmentHost.internal 1.0.0 [UNUSED]
```

## Uninstall require refresh

> Run: bndrun-host-with-fragment.bndrun

```
g! lb
START LEVEL 1
   ID|State      |Level|Name
    ...
    7|Active     |    1|de.jwausle.osgi.fragmentHost (1.0.0.202301112148)|1.0.0.202301112148
    8|Resolved   |    1|de.jwausle.osgi.fragmentBundle (1.0.0.202301112146)|1.0.0.202301112146

g! uninstall 8

g! fgm2
--------------------------------------------------
Fragment context: org.apache.felix.framework.BundleContextImpl@71b1176b
--------------------------------------------------
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:0/folder/file.txt
Fragment Host file.txt
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_8.0:0/folder/file.txt
Fragment Bundle file.txt
--------------------------------------------------
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:1/folder/file.txt
Fragment Host file.txt
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:2/folder/file.txt
Fragment Bundle file.txt

g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.fragmentHost [7] provides:
------------------------------------------
osgi.wiring.package; de.jwausle.osgi.fragmentHost.internal 1.0.0 [UNUSED]

g! refresh 7
g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.fragmentHost [7] provides:
------------------------------------------
osgi.wiring.package [EMPTY]

g! fgm2
gogo: CommandNotFoundException: Command not found: fgm2
g! fgm
--------------------------------------------------
Bundle context: org.apache.felix.framework.BundleContextImpl@2ec14f0f
--------------------------------------------------
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:0/folder/file.txt
Fragment Host file.txt
--------------------------------------------------
bundle://0f136b36-3e3f-4f9f-9f60-715466b7481d_7.0:1/folder/file.txt
Fragment Host file.txt
```
