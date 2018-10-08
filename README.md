# minweb
20180217

<!-- ##################8070端口项目################################################################# -->
<!-- name修改 -->
<Service name="Catalina_8070">
  <!-- port修改 --><!-- 资源设置了必须要https方式访问，此时Tomcat会自动重定向到这个redirectPort设置的https端口 -->
  <Connector port="8070" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8470" />
  <!-- name修改 -->
  <Engine name="Catalina_8070" defaultHost="localhost">
    <Realm className="org.apache.catalina.realm.LockOutRealm">
      <Realm className="org.apache.catalina.realm.UserDatabaseRealm" resourceName="UserDatabase"/>
    </Realm>
    <!-- appBase修改 -->
    <Host name="localhost"  appBase="Catalina_8070" unpackWARs="true" autoDeploy="true">
      <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs" prefix="localhost_access_log" suffix=".txt" pattern="%h %l %u %t &quot;%r&quot; %s %b" />
    </Host>
  </Engine>
</Service>
