kerberos-tools
======

A set of tools to help debug kerberos issues from the command line.

Simply clone this project build it with `mvn clean install` and execute the command scripts at the root of the project.

Currently, ktchk is the sole command script and it tests the ability to use a keytab to login via kerberos.
It assumes the use of a properties file and one is located in the root of the project for your convenience.
Customize it to match your principal and keytab details.

```
[root@c6402 kerberos-tools]# ./ktchk
1.6.0_35
======= property file [/vagrant/kerberos-tools/./krb.properties]
Debug is  true storeKey false useTicketCache true useKeyTab true doNotPrompt true ticketCache is /tmp/krb5cc_510 isInitiator true KeyTab is /etc/security/keytabs/hdfs.headless.keytab refreshKrb5Config is true principal is hdfs-ljm tryFirstPass is false useFirstPass is false storePass is false clearPass is false
======= starting JAAS login...
Refreshing Kerberos configuration
Acquire TGT from Cache
>>>DEBUG <CCacheInputStream>  client principal is hdfs-ljm@EXAMPLE.COM
>>>DEBUG <CCacheInputStream> server principal is krbtgt/EXAMPLE.COM@EXAMPLE.COM
>>>DEBUG <CCacheInputStream> key type: 18
>>>DEBUG <CCacheInputStream> auth time: Thu Aug 27 14:12:32 UTC 2015
>>>DEBUG <CCacheInputStream> start time: Thu Aug 27 14:12:32 UTC 2015
>>>DEBUG <CCacheInputStream> end time: Fri Aug 28 14:00:27 UTC 2015
>>>DEBUG <CCacheInputStream> renew_till time: Thu Aug 27 14:12:32 UTC 2015
>>> CCacheInputStream: readFlags()  FORWARDABLE; RENEWABLE; INITIAL;
>>>DEBUG <CCacheInputStream>  client principal is hdfs-ljm@EXAMPLE.COM
>>>DEBUG <CCacheInputStream> server principal is X-CACHECONF:/krb5_ccache_conf_data/fast_avail/krbtgt/EXAMPLE.COM@EXAMPLE.COM
>>>DEBUG <CCacheInputStream> key type: 0
>>>DEBUG <CCacheInputStream> auth time: Thu Jan 01 00:00:00 UTC 1970
>>>DEBUG <CCacheInputStream> start time: Thu Jan 01 00:00:00 UTC 1970
>>>DEBUG <CCacheInputStream> end time: Thu Jan 01 00:00:00 UTC 1970
>>>DEBUG <CCacheInputStream> renew_till time: Thu Jan 01 00:00:00 UTC 1970
>>> CCacheInputStream: readFlags()
>>>DEBUG <CCacheInputStream>  client principal is hdfs-ljm@EXAMPLE.COM
>>>DEBUG <CCacheInputStream> server principal is /HTTP/c6401.ambari.apache.org
>>>DEBUG <CCacheInputStream> key type: 18
>>>DEBUG <CCacheInputStream> auth time: Thu Aug 27 14:12:32 UTC 2015
>>>DEBUG <CCacheInputStream> start time: Thu Aug 27 14:12:32 UTC 2015
>>>DEBUG <CCacheInputStream> end time: Fri Aug 28 14:00:27 UTC 2015
>>>DEBUG <CCacheInputStream> renew_till time: Thu Aug 27 14:12:32 UTC 2015
>>> CCacheInputStream: readFlags()  FORWARDABLE; RENEWABLE;
>>>DEBUG <CCacheInputStream>  client principal is hdfs-ljm@EXAMPLE.COM
>>>DEBUG <CCacheInputStream> server principal is HTTP/c6401.ambari.apache.org@EXAMPLE.COM
>>>DEBUG <CCacheInputStream> key type: 18
>>>DEBUG <CCacheInputStream> auth time: Thu Aug 27 14:12:32 UTC 2015
>>>DEBUG <CCacheInputStream> start time: Thu Aug 27 14:12:32 UTC 2015
>>>DEBUG <CCacheInputStream> end time: Fri Aug 28 14:00:27 UTC 2015
>>>DEBUG <CCacheInputStream> renew_till time: Thu Aug 27 14:12:32 UTC 2015
>>> CCacheInputStream: readFlags()  FORWARDABLE; RENEWABLE;
Principal is hdfs-ljm@EXAMPLE.COM
======= login:  true
Commit Succeeded

======= commit: true
======= Subject: Subject:
	Principal: hdfs-ljm@EXAMPLE.COM
	Private Credential: Ticket (hex) =
0000: 61 82 01 55 30 82 01 51   A0 03 02 01 05 A1 0D 1B  a..U0..Q........
0010: 0B 45 58 41 4D 50 4C 45   2E 43 4F 4D A2 20 30 1E  .EXAMPLE.COM. 0.
0020: A0 03 02 01 02 A1 17 30   15 1B 06 6B 72 62 74 67  .......0...krbtg
0030: 74 1B 0B 45 58 41 4D 50   4C 45 2E 43 4F 4D A3 82  t..EXAMPLE.COM..
0040: 01 17 30 82 01 13 A0 03   02 01 12 A1 03 02 01 01  ..0.............
0050: A2 82 01 05 04 82 01 01   D0 B5 58 8C F0 02 3E 44  ..........X...>D
0060: 91 B4 F1 ED C1 AE AD 51   FF 6B 98 AB C8 90 A0 DD  .......Q.k......
0070: AB E2 59 E5 4A 68 C2 6E   50 A5 2A A3 53 60 2A 32  ..Y.Jh.nP.*.S`*2
0080: CA 80 48 50 BD EB 4D 8A   AC 05 86 AF D4 57 38 4B  ..HP..M......W8K
0090: 26 F1 E3 25 DD 76 87 93   83 01 D7 7D 2C 59 67 CC  &..%.v......,Yg.
00A0: 97 89 6E FB CD 4C 5C 93   07 B7 92 9D 80 1E 6B DE  ..n..L\.......k.
00B0: B7 BB 78 C7 4B F2 11 CD   09 10 82 8B 9B 7F F2 55  ..x.K..........U
00C0: 8A 22 CB 16 E2 EC CB 82   03 0E B2 58 0C 31 C6 77  .".........X.1.w
00D0: 72 2F 4C 9A 09 63 DE 4F   95 CB 89 C4 56 91 82 C3  r/L..c.O....V...
00E0: 34 9D FF 19 0A 9C B5 7A   9B 9A 38 09 8F D0 42 AD  4......z..8...B.
00F0: 49 15 25 89 81 E3 1E 3E   F3 C6 8F F0 E9 9A 89 0B  I.%....>........
0100: C6 3C 37 1B 35 FF B7 EF   A1 33 99 EB C8 2C 6C F3  .<7.5....3...,l.
0110: D0 68 F7 45 58 47 58 94   AA 48 ED 8A C8 9E 53 47  .h.EXGX..H....SG
0120: 59 1F 7F 79 8A 24 1B 71   C5 B6 0F F5 5C BE AC 96  Y..y.$.q....\...
0130: 3F 1B 74 B0 D7 D7 3D 90   87 66 6A 3C 59 C9 F8 33  ?.t...=..fj<Y..3
0140: 1B 35 56 C4 57 8A 2D E9   05 17 EA 60 EC A4 5A 10  .5V.W.-....`..Z.
0150: FE C3 B6 F5 DC CD 32 A0   CD                       ......2..

Client Principal = hdfs-ljm@EXAMPLE.COM
Server Principal = krbtgt/EXAMPLE.COM@EXAMPLE.COM
Session Key = EncryptionKey: keyType=18 keyBytes (hex dump)=
0000: FF CC 55 D2 A7 B3 EA 5F   DF 10 B7 07 05 DE B9 63  ..U...._.......c
0010: CB 65 E8 78 44 79 94 1D   3A AE F2 AF 35 AE AD 1C  .e.xDy..:...5...


Forwardable Ticket true
Forwarded Ticket false
Proxiable Ticket false
Proxy Ticket false
Postdated Ticket false
Renewable Ticket true
Initial Ticket true
Auth Time = Thu Aug 27 14:12:32 UTC 2015
Start Time = Thu Aug 27 14:12:32 UTC 2015
End Time = Fri Aug 28 14:00:27 UTC 2015
Renew Till = Thu Aug 27 14:12:32 UTC 2015
Client Addresses  Null
```