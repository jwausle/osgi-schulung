# Fragment bundle



> Fragment bundle can export packages and provide DS

```
g! fgm
bundle://4cdd40f8-2c12-48c8-b938-cdb93130bccc_7.0:1/folder/file.txt
Fragment Host file.txt
bundle://4cdd40f8-2c12-48c8-b938-cdb93130bccc_7.0:2/folder/file.txt
Fragment Bundle file.txt

g! inspect cap osgi.wiring.package 8
de.jwausle.osgi.fragmentBundle [8] provides:
--------------------------------------------
osgi.wiring.package [EMPTY]

g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.fragmentHost [7] provides:
------------------------------------------
osgi.wiring.package; de.jwausle.osgi.fragmentHost.internal 1.0.0 [UNUSED]

```