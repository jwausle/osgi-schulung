## Added 

- added `bnd.bndrun`

## Use cases

1) list (scr:list) 

```
g! list 
io.github.mnl.osgiGettingStarted.calculator.ds.CalculatorImpl in bundle 2 (io.github.mnl.osgiGettingStarted.calculator.ds:1.0.0) enabled, 0 instances.
```

2) scr:info io.github.mnl.osgiGettingStarted.calculator.ds.CalculatorImpl

```
g! scr:info io.github.mnl.osgiGettingStarted.calculator.ds.CalculatorImpl
Component Description: io.github.mnl.osgiGettingStarted.calculator.ds.CalculatorImpl
====================================================================================
Class:         io.github.mnl.osgiGettingStarted.calculator.ds.CalculatorImpl
Bundle:        2 (io.github.mnl.osgiGettingStarted.calculator.ds:1.0.0)
Enabled:       true
Immediate:     false
Services:      [io.github.mnl.osgiGettingStarted.calculator.Calculator]
Scope:         singleton
Config PID(s): [io.github.mnl.osgiGettingStarted.calculator.ds.CalculatorImpl], Policy: require
Base Props:    (2 entries)
  osgi.ds.satisfying.condition.target<String> = (osgi.condition.id=true)
  service.vendor<String> = Michael N. Lipp
```