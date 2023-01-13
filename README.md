# threads depedency
B, C independently depend on A
D depend on B & C

# build
./gradlew clean; ./gradlew build

# run
./gradlew run

# sample output
~/workspace/threads(main)>./gradlew run


> Task :run
Thread A starting ...
Thread A exiting ...
Thread B starting ...
Thread C starting ...
Thread B exiting ...
Thread C exiting ...
Thread D starting ...
Thread D exiting ...

Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/7.4/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 5s
2 actionable tasks: 1 executed, 1 up-to-date
~/workspace/threads(main)>

