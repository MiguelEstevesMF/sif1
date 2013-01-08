workers.proprieties

  worker.list=workerlb

  worker.worker1.type=ajp13
  worker.worker1.host=192.168.1.2
  worker.worker1.port=8009
  worker.worker1.lbfactor=50

  worker.worker2.type=ajp13
  worker.worker2.host=localhost
  worker.worker2.port=8009
  worker.worker2.lbfactor=50

  worker.workerlb.type=lb
  worker.workerlb.sticky_session=true
  worker.workerlb.balance_workers=worker1, worker2



httpd.conf

...
LoadModule jk_module modules/mod_jk.so
JkWorkersFile conf/workers.properties
JkMount  /* workerlb
...



server.xml

...
<Connector protocol="AJP/1.3" port="8009" address="${jboss.bind.address},IP_DO_LOADBALANCER"
         redirectPort="8443" />
...