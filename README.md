# S-expression calculator

Provides a command line Java-program that acts as a simple calculator: it takes a single argument as an expression and prints out the integer result of evaluating it.

You should clone repository and compile program before use. Program was created and tested under Java 17, but might also work with Java 8 or greater.

There is an example of program invocation:

```

PS> java ua.jdev.calc.Calculator 45
45

PS> java ua.jdev.calc.Calculator "(add 10 (multiply 7 12 3))"
262

```


You may also download [s-calc-1.0.jar](https://github-registry-files.githubusercontent.com/598916003/a32a5600-a7ea-11ed-9078-e942b40ff6de?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20230208%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230208T184944Z&X-Amz-Expires=300&X-Amz-Signature=bd173dea112d64469014416f0f0580f19877ea451555bd5e5c1debd3e8b12bcc&X-Amz-SignedHeaders=host&actor_id=0&key_id=0&repo_id=598916003&response-content-disposition=filename%3Ds-calc-1.0.jar&response-content-type=application%2Foctet-stream)
from package [ua.jdev.calc.s-calc](https://github.com/zlodij/s-calc/packages/1787560) with compiled calculator (requires JRE 17 to execute):

```

PS> java -jar s-calc-1.0.jar "45"
45

PS> java -jar s-calc-1.0.jar "(add 10 (multiply 7 12 3))"
262

```
