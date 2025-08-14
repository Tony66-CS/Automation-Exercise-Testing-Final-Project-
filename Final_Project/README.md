# TestNG XML Test Suites

This directory contains individual XML test suites for each test case, allowing you to run specific test cases or all tests together.

## Available Test Suites

### Individual Test Cases
- `TestCase1.xml` - Runs only TestCase1
- `TestCase2.xml` - Runs only TestCase2
- `TestCase3.xml` - Runs only TestCase3
- `TestCase4.xml` - Runs only TestCase4
- `TestCase5.xml` - Runs only TestCase5
- `TestCase6.xml` - Runs only TestCase6
- `TestCase7.xml` - Runs only TestCase7
- `TestCase8.xml` - Runs only TestCase8
- `TestCase9.xml` - Runs only TestCase9
- `TestCase10.xml` - Runs only TestCase10
- `TestCase11.xml` - Runs only TestCase11
- `TestCase12.xml` - Runs only TestCase12
- `TestCase13.xml` - Runs only TestCase13
- `TestCase14.xml` - Runs only TestCase14
- `TestCase15.xml` - Runs only TestCase15
- `TestCase16.xml` - Runs only TestCase16
- `TestCase17.xml` - Runs only TestCase17
- `TestCase18.xml` - Runs only TestCase18
- `TestCase19.xml` - Runs only TestCase19
- `TestCase20.xml` - Runs only TestCase20
- `TestCase21.xml` - Runs only TestCase21
- `TestCase22.xml` - Runs only TestCase22
- `TestCase23.xml` - Runs only TestCase23
- `TestCase24.xml` - Runs only TestCase24
- `TestCase25.xml` - Runs only TestCase25
- `TestCase26.xml` - Runs only TestCase26

### Master Suite
- `AllTestCases.xml` - Runs all test cases together

## How to Run

### Using Maven Command Line

#### Run Individual Test Case
```bash
# Navigate to project directory
cd Final_Project

# Run specific test case (e.g., TestCase1)
mvn test -DsuiteXmlFile=src/test/resources/test-suites/TestCase1.xml

# Run another test case (e.g., TestCase5)
mvn test -DsuiteXmlFile=src/test/resources/test-suites/TestCase5.xml
```

#### Run All Test Cases
```bash
# Run all test cases together
mvn test -DsuiteXmlFile=src/test/resources/test-suites/AllTestCases.xml
```

### Using IDE (IntelliJ IDEA, Eclipse)

1. Right-click on any XML file in the `test-suites` directory
2. Select "Run as TestNG Suite" or similar option
3. The IDE will execute the selected test suite

### Using TestNG Command Line

If you have TestNG installed globally:
```bash
# Run individual test case
java -cp "path/to/testng.jar:path/to/your/classes" org.testng.TestNG src/test/resources/test-suites/TestCase1.xml

# Run all test cases
java -cp "path/to/testng.jar:path/to/your/classes" org.testng.TestNG src/test/resources/test-suites/AllTestCases.xml
```

## Suite Configuration

Each XML suite is configured with:
- **Parallel execution**: Set to `false` for sequential execution
- **Suite name**: Descriptive name for the specific test case
- **Test name**: Clear identification of what's being tested
- **Class reference**: Points to the specific test case class

## Benefits

1. **Selective Testing**: Run only the test cases you need
2. **Faster Execution**: Individual test cases run faster than the full suite
3. **Debugging**: Easier to isolate and debug specific test scenarios
4. **CI/CD Integration**: Can be used in continuous integration pipelines
5. **Parallel Execution**: Can be modified to run tests in parallel if needed

## Customization

You can modify any XML suite to:
- Add more test classes
- Change parallel execution settings
- Add test groups
- Configure test parameters
- Set up listeners

## Example: Running Multiple Specific Test Cases

If you want to run only TestCase1, TestCase5, and TestCase10, you can create a custom suite or run them individually:

```bash
# Run TestCase1
mvn test -DsuiteXmlFile=src/test/resources/test-suites/TestCase1.xml

# Run TestCase5
mvn test -DsuiteXmlFile=src/test/resources/test-suites/TestCase5.xml

# Run TestCase10
mvn test -DsuiteXmlFile=src/test/resources/test-suites/TestCase10.xml
```

## Notes

- Make sure all dependencies are properly configured in `pom.xml`
- Test reports will be generated in the `test-output` directory
- Each suite will create its own test report
- The browser will open and close for each test case execution
