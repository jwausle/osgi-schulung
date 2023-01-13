# Added 

> Run `bnd.bndrun`

```
g! allservicereferences null null
000004   0 Condition                                
000011   4 Converter                                
000014   4 Posix                                    
000010   3 CommandProcessor                         
000013   4 Procedural                               
000003   0 StartLevel                               
000025   6 ManagedService                           org.apache.felix.scr.ScrService
000024   3 Converter                                
000018   5 LogReaderService                         
000008   2 Files                                    
000009   3 ThreadIO                                 
000001   0 Resolver                                 
000007   2 Inspect                                  
000019   5 LoggerAdmin                              
000027   1 Runnable                                 
000016   4 Shell                                    
000023   6 ComponentCommands                        
000028   1 SrvCommand                               
000006   2 Basic                                    
000026   6 MetaTypeProvider                         
000017   5 LogService | LoggerFactory               
000005   0 Object | Launcher                        
000020   6 ServiceComponentRuntime                  
000015   4 Telnet                                   
000002   0 PackageAdmin                             
000012   4 Builtin

g! each (allservicereferences null null) { $it properties } 
[service.id=4, objectClass=[Ljava.lang.String;@4dec3e11, service.scope=singleton, osgi.condition.id=true, service.bundleid=0]
...
[osgi.command.function=[Ljava.lang.String;@759e1afe, service.id=12, objectClass=[Ljava.lang.String;@6d47ca3, osgi.command.scope=gogo, service.scope=singleton, service.bundleid=4]
```

2) Service references

```
g! servicereferences org.osgi.service.startlevel.StartLevel null
000003   0 StartLevel                               

g! each (servicereferences org.osgi.service.startlevel.StartLevel null) { $it properties }
[service.id=3, objectClass=[Ljava.lang.String;@1957779c, service.scope=singleton, service.bundleid=0]
```

