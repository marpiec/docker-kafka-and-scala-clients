Sometimes it might be necessary to run this:
iptables -F
so docker images would see host, or dns

A Solution

Hmm, so we needed to allow forwarding between docker0 and eth0 , eh? That’s easy! We just added the following rules to our iptables set:

# Forward chain between docker0 and eth0
iptables -A FORWARD -i docker0 -o eth0 -j ACCEPT
iptables -A FORWARD -i eth0 -o docker0 -j ACCEPT

# IPv6 chain if needed
ip6tables -A FORWARD -i docker0 -o eth0 -j ACCEPT
ip6tables -A FORWARD -i eth0 -o docker0 -j ACCEPT
Add or alter these rules as needed, and you too will be able to build Dockerfiles properly behind an iptables firewall.

https://blog.andyet.com/2014/09/11/docker-host-iptables-forwarding


2. advertised.host.name - it should be set to host ip, so it will be easily resolvable from outside container