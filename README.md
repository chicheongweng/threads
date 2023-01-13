# Java version
openjdk version "11.0.17" 2022-10-18 LTS

OpenJDK Runtime Environment Corretto-11.0.17.8.1 (build 11.0.17+8-LTS)

OpenJDK 64-Bit Server VM Corretto-11.0.17.8.1 (build 11.0.17+8-LTS, mixed mode)

# threads depedency
B, C independently depend on A

D depends on B & C

# build and run
./gradlew clean; ./gradlew build; ./gradlew run

# sample output
~/workspace/threads(main)>./gradlew run


> Task :run

A starting ...

A exiting ...

B joining A

B starting ...

B exiting ...

C joining A

C starting ...

C exiting ...

D joining B

D joining C

D starting ...

D exiting ...
