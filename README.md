# ArgumentCatcher

ArgumentCatcher is a Java based executable made to capture arguments passed to it.

## Usage Scenario

Say you have an executable ```Foo.exe``` which launches ```Bar.exe``` and passes some arguments to it and ```Bar.exe```
does some magic. Now you are curious about what arguments might have ```Foo.exe``` passed to ```Bar.exe``` so that the
magic happens. This is exactly where ArgumentCatcher comes into play.

## Installation

You can download the latest Windows Executable or
JAR [from the releases page](https://github.com/itsyourap/ArgumentCatcher/releases).

Preferably, you can build ArgumentCatcher by cloning the [Git](https://github.com/itsyourap/ArgumentCatcher)
repository:

    git clone https://github.com/itsyourap/ArgumentCatcher.git

You will need [Java Development Kit (JDK)](https://en.wikipedia.org/wiki/Java_Development_Kit) to build this project.

## Usage

Here we will be
solving [this example situation](#usage-scenario) with
the help of ArgumentCatcher.

1. Rename ArgumentCatcher executable to ```Bar.exe``` and put it in place of the original ```Bar.exe```
2. Now whenever ```Foo.exe``` launches ```Bar.exe``` with some arguments, a folder with name ```.argumentcatcher``` is
   created in the same folder as the executable is created and a LOG file is written into the folder which contains all
   the arguments in a readable manner.
3. The log file is always appended, so don't worry about overwriting.

Now say, you want ArgumentCatcher to return some output to ```Foo.exe``` for a specific argument(s) passed to
ArgumentCatcher so that ```Foo.exe``` may continue its further operations.

To make ArgumentCatcher return specific outputs for specific arguments, do this:-

1. In the ```.argumentcatcher``` folder, there will be a folder named ```output``` (Create it if not present).
2. Make a folder with the name of your executable, (here ```Bar.exe```) and open it.
3. In this folder, put files with the name of the argument and add ```.txt``` as extension and add the desired output in
   the file.

For example, say you want ArgumentCatcher to return ```beta``` when argument ```alpha``` is passed to ```Bar.exe```. So,
we first rename ArgumentCatcher executable to ```Bar.exe``` and put it in place of the original ```Bar.exe```. Next we
open ```.argumentcatcher``` folder and open ```output``` folder in it. Now in the ```output``` folder we create a folder
with the name ```Bar.exe``` and open it. In the ```Bar.exe``` folder, we create ```alpha.txt``` file which will contain
this:-

    beta

So now, whenever ```Foo.exe``` tries to pass argument ```alpha``` to ```Bar.exe```, it will get the output contained in
the ```alpha.txt``` file, which in this case is ```beta```.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[GPLv3](https://github.com/itsyourap/ArgumentCatcher/blob/main/LICENSE)
