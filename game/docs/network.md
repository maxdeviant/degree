Network
=======

Modify `/etc/network/interfaces` with the provided network information:
```
auto em1
iface em1 inet static
address 192.168.1.7
netmask 255.255.255.0
gateway 192.168.1.1
```

Restart the service: `sudo ifdown eth0 && sudo ifup eth0`
