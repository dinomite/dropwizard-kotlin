# Running

This is a Dropwizard app, so running requires you to pass what it should do (probably `server`) and a configuration file.
The lazy way to do configuration is just have it in your service module, so that's what this app does.  Run it in dev by
passing `server service/development.yml`. If you are running in IntelliJ, the main class is ExampleApplication and you
need to put that in the Program Arguments of the Run configuration.  From the command line you can do

    ./gradlew stage && java -jar service/build/libs/dropwizard-example-all.jar server service/development.yml
    
which will build a fat jar and run it.
