# Samples

The `jw:run` try to show guava Cache.class classpath resource.

> Java run Main.class 

## 1) -manifest: ./META-INF/MANIFEST-simple.MF 

Getting started with gogo commands `help,headers,lb,bundle,inspect`.

> bnd-default.bndrun

```
!g help
!g help headers
!g headers 4
!g felix:headers 4

!g inspect cap osgi.wiring.package 4
de.jwausle.osgi.classpath [4] provides:
---------------------------------------
osgi.wiring.package; de.jwausle.osgi.classpath 0.0.0 [UNUSED]

!g bundle 1
!g bundle 2
!g bundle 3
```

## 2) -manifest: ./META-INF/MANIFEST-default.MF

Bundle without guava import will fail with NoClassDefError.

> bnd-default.bndrun

```
g! help
..
jw:run

g! run
java.lang.reflect.InvocationTargetException
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at org.apache.felix.gogo.runtime.Reflective.invoke(Reflective.java:143)
	at org.apache.felix.gogo.runtime.CommandProxy.execute(CommandProxy.java:91)
	at org.apache.felix.gogo.runtime.Closure.executeCmd(Closure.java:599)
	at org.apache.felix.gogo.runtime.Closure.executeStatement(Closure.java:526)
	at org.apache.felix.gogo.runtime.Closure.execute(Closure.java:415)
	at org.apache.felix.gogo.runtime.Pipe.doCall(Pipe.java:416)
	at org.apache.felix.gogo.runtime.Pipe.call(Pipe.java:229)
	at org.apache.felix.gogo.runtime.Pipe.call(Pipe.java:59)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1130)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:630)
	at java.base/java.lang.Thread.run(Thread.java:832)
Caused by: java.lang.NoClassDefFoundError: com/google/common/cache/Cache
	at de.jwausle.osgi.classpath.Api.run(Api.java:8)
	at de.jwausle.osgi.classpath.internal.RunCommand.run2(RunCommand.java:9)
	... 16 more
```

> Warum? import com.google.common.cache.Cache; cannot imported

## 3)  -manifest: ./META-INF/MANIFEST-import-cache.MF | ./META-INF/MANIFEST-require-bundle-cache.MF

Bundle with guava import lead to successful `jw:run` execution.

> bnd-default.bndrun (fail)
> bnd-guava29.bndrun

```
g! run
bundle://bfcaf5e1-4616-46bc-a477-5c35ca998458_6.0:1/com/google/common/cache/Cache.class

g! inspect req osgi.wiring.package 4
de.jwausle.osgi.classpath [4] requires:
---------------------------------------
osgi.wiring.package; (osgi.wiring.package=org.osgi.framework) resolved by:
   osgi.wiring.package; org.osgi.framework 1.9.0 from org.apache.felix.framework [0]
osgi.wiring.package; (osgi.wiring.package=com.google.common.cache) resolved by:
   osgi.wiring.package; com.google.common.cache 29.0.0 from com.google.guava [6]
   
g! inspect cap osgi.wiring.package 6
com.google.guava [6] provides:
------------------------------
osgi.wiring.package; com.google.common.annotations 29.0.0 [UNUSED]
osgi.wiring.package; com.google.common.base 29.0.0 [UNUSED]
osgi.wiring.package; com.google.common.cache 29.0.0 required by:
   de.jwausle.osgi.classpath [4]   
```

> bnd-guava30.bndrun

```
lb
START LEVEL 1
   ID|State      |Level|Name
	...
    4|Active     |    1|de.jwausle.osgi.classpath (1.0.0.manual)|1.0.0.manual
    5|Active     |    1|Guava InternalFutureFailureAccess and InternalFutures (1.0.1)|1.0.1
    6|Active     |    1|Guava: Google Core Libraries for Java (29.0.0.jre)|29.0.0.jre
    7|Active     |    1|Guava: Google Core Libraries for Java (30.1.0.jre)|30.1.0.jre

g! inspect req osgi.wiring.package 4
de.jwausle.osgi.classpath [4] requires:
---------------------------------------
osgi.wiring.package; (osgi.wiring.package=org.osgi.framework) resolved by:
   osgi.wiring.package; org.osgi.framework 1.9.0 from org.apache.felix.framework [0]
osgi.wiring.package; (osgi.wiring.package=com.google.common.cache) resolved by:
   osgi.wiring.package; com.google.common.cache 30.1.0 from com.google.guava [7]

g! inspect cap osgi.wiring.package 7
com.google.guava [7] provides:
------------------------------
osgi.wiring.package; com.google.common.annotations 30.1.0 [UNUSED]
osgi.wiring.package; com.google.common.base 30.1.0 [UNUSED]
osgi.wiring.package; com.google.common.cache 30.1.0 required by:
   de.jwausle.osgi.classpath [4]
...

g! inspect cap osgi.wiring.package 6
com.google.guava [6] provides:
------------------------------
...
osgi.wiring.package; com.google.common.cache 29.0.0 [UNUSED]
...
```

> bnd-guava31.bndrun

```
lb
START LEVEL 1
   ID|State      |Level|Name
    ...
    4|Active     |    1|de.jwausle.osgi.classpath (1.0.0.manual)|1.0.0.manual
    5|Active     |    1|Guava InternalFutureFailureAccess and InternalFutures (1.0.1)|1.0.1
    6|Active     |    1|Guava: Google Core Libraries for Java (29.0.0.jre)|29.0.0.jre
    7|Active     |    1|Guava: Google Core Libraries for Java (30.1.0.jre)|30.1.0.jre
    8|Active     |    1|Guava: Google Core Libraries for Java (31.0.0.jre)|31.0.0.jre

g! inspect cap osgi.wiring.package 8
com.google.guava [8] provides:
------------------------------
osgi.wiring.package; com.google.common.annotations 31.0.0 [UNUSED]
osgi.wiring.package; com.google.common.base 31.0.0 [UNUSED]
osgi.wiring.package; com.google.common.cache 31.0.0 required by:
   de.jwausle.osgi.classpath [4]
   
g! inspect req osgi.wiring.package 4
de.jwausle.osgi.classpath [4] requires:
---------------------------------------
osgi.wiring.package; (osgi.wiring.package=org.osgi.framework) resolved by:
   osgi.wiring.package; org.osgi.framework 1.9.0 from org.apache.felix.framework [0]
osgi.wiring.package; (&(osgi.wiring.package=com.google.common.cache)(version>=29.0.0)) resolved by:
   osgi.wiring.package; com.google.common.cache 31.0.0 from com.google.guava [8]   
```

## -manifest: ./META-INF/MANIFEST-import-cache29.MF

Bundle import package>=29 resolve in highest available package wiring(31).

> bnd-guava31.bndrun

```
g! inspect req osgi.wiring.package 4
de.jwausle.osgi.classpath [4] requires:
---------------------------------------
osgi.wiring.package; (osgi.wiring.package=org.osgi.framework) resolved by:
   osgi.wiring.package; org.osgi.framework 1.9.0 from org.apache.felix.framework [0]
osgi.wiring.package; (&(osgi.wiring.package=com.google.common.cache)(version>=29.0.0)) resolved by:
   osgi.wiring.package; com.google.common.cache 31.0.0 from com.google.guava [8]
```

## -manifest: ./META-INF/MANIFEST-import-cache29-30.MF

Bundle import package[29,30) resolve in highest available package wiring(29).

> bnd-guava31.bndrun

```
g! inspect req osgi.wiring.package 4
de.jwausle.osgi.classpath [4] requires:
---------------------------------------
osgi.wiring.package; (osgi.wiring.package=org.osgi.framework) resolved by:
   osgi.wiring.package; org.osgi.framework 1.9.0 from org.apache.felix.framework [0]
osgi.wiring.package; (&(osgi.wiring.package=com.google.common.cache)(version>=29.0.0)(!(version>=30.0.0))) resolved by:
   osgi.wiring.package; com.google.common.cache 29.0.0 from com.google.guava [6]
```