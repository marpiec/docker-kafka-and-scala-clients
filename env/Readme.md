Sometimes it might be necessary to run this:
iptables -F
so docker images would see host, or dns. At least in Fedora this sometimes happen.


2. advertised.host.name - in kafka configuration should be set to host ip, so it will be easily resolvable from outside container
