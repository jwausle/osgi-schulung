
```
g! cm:list
Configuration list:
----------------------------
   (none)

g! cm:get io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld
no configuration for pid 'io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld' (use 'create' to create one)   

g! cm:create io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld

g! cm:list
Configuration list:
----------------------------
io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld     ?

g! cm:get io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld

g! cm:put io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld waitTime 5000
```