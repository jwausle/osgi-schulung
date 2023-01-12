# Added 

> Run `bnd.bndrun`

# Use cases 

```
g! lb
START LEVEL 1
   ID|State      |Level|Name
    0|Active     |    0|System Bundle (7.0.3)|7.0.3
    1|Active     |    1|SimpleBundle-DM2 (1.2.0)|1.2.0
    2|Active     |    1|Apache Felix Gogo Command (1.1.2)|1.1.2
    3|Active     |    1|Apache Felix Gogo Runtime (1.1.6)|1.1.6
    4|Active     |    1|Apache Felix Gogo Shell (1.1.4)|1.1.4
    5|Active     |    1|Apache Felix Log Service (1.2.6)|1.2.6
    6|Active     |    1|Apache Felix Declarative Services (2.2.0.RC1)|2.2.0.RC1
    7|Active     |    1|org.osgi:osgi.promise (6.0.0.201505202027)|6.0.0.201505202027
    
g! help 
...
jw:srv

g! srv
000004   0 Condition                                
...
000012   4 Builtin        

g! each (srv) { $it properties } 
[service.id=4, objectClass=[Ljava.lang.String;@4dec3e11, service.scope=singleton, osgi.condition.id=true, service.bundleid=0]
...
[osgi.command.function=[Ljava.lang.String;@759e1afe, service.id=12, objectClass=[Ljava.lang.String;@6d47ca3, osgi.command.scope=gogo, service.scope=singleton, service.bundleid=4]

g! scr:list
io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld2 in bundle 1 (SimpleBundle-DM2:1.2.0) enabled, 1 instance.
    Id: 2, State:SATISFIED
io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand in bundle 1 (SimpleBundle-DM2:1.2.0) enabled, 1 instance.
    Id: 3, State:SATISFIED
    
g! scr:info io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand
Component Description: io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand
===============================================================================
Class:         io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand
Bundle:        1 (SimpleBundle-DM2:1.2.0)
Enabled:       true
Immediate:     false
Services:      [io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand]
Scope:         singleton
Config PID(s): [io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand], Policy: optional
Base Props:    (3 entries)
  osgi.command.function<String> = srv
  osgi.command.scope<String> = jw
  osgi.ds.satisfying.condition.target<String> = (osgi.condition.id=true)

Component Configuration Id: 3
-----------------------------
State:        ACTIVE
Service:      28 [io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand]
    Used by bundle 0 (org.apache.felix.framework:7.0.3)
Config Props: (5 entries)
  component.id<Long> = 3
  component.name<String> = io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand
  osgi.command.function<String> = srv
  osgi.command.scope<String> = jw
  osgi.ds.satisfying.condition.target<String> = (osgi.condition.id=true)
References:   (total 1)
  - osgi.ds.satisfying.condition: org.osgi.service.condition.Condition SATISFIED 1..1 dynamic
    target=(osgi.condition.id=true) scope=bundle (1 binding):
    * Bound to [4] from bundle 0 (org.apache.felix.framework:7.0.3)
    
g! srv
g! scr:info io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand
...
Immediate:     false

g! srv
gogo: CommandNotFoundException: Command not found: srv

g! enable io.github.mnl.osgiGettingStarted.simpleBundle.SrvCommand
```

