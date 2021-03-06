# NanoSat MO Framework SDK
The SDK contains a set of tools and example projects in order to facilitate quicker development of applications by the framework users.

The SDK depends on the NMF Mission - Software Simulator.

## SDK content

### Tools
- [Consumer Test Tool](tools/consumer-test-tool) - allows consuming all of the services exposed by NMF through an user-friendly GUI
- [Package Assembler](tools/package-assembler) - allows packaging space apps into a deliverables to mission

### [Space Examples](examples/space)
Various space applications demonstrating the uses of the on-board framework.

### [Ground Examples](examples/ground)
Various ground applications demonstrating the uses of the ground framework.

### [Documentation](sdk-package/resources/docs)
Various supporting documents, including:
- Space Apps Development Guide
- Ground Apps Development Guide
- Software Requirements Document
- Software Design Document
- Relevant CCSDS standards
- CCSDS MO Services Interface Control Documents (MO ICDs)
- Javadocs (only in the SDK Release Package) - aggregated javadocs of the CCSDS MO Framework and the NanoSat MO Framework

### SDK Release package
The release packages contain binaries of the tools, most relevant examples, mission simulator GUI, and documentation.

## Building a release package

Instructions:
1. Update the MO ICDs if there were changes in the NMF MO XML files
2. Invoke `mvn clean install` target on the main POM file
3. The packaged SDK can be found under `sdk-package/target`
  
Tips:
- Full build takes some time.
Afterwards it is possible to rebuild particular sub-projects individually,
or to use `mvn install -Dmaven.javadoc.skip=true -Desa.nmf.sdk.assembly.quickbuild=true` to speed up the intermediate build process.

## Source Code
The source code of the NanoSat MO Framework can be found on [GitHub].

## Bugs Reporting
Bug Reports can be submitted on: [Bug Reports]

## License
The NanoSat MO Framework is **licensed** under the **[European Space Agency Public License - v2.0]**.

[![][ESAImage]][website]
	
	
[ESAImage]: http://www.esa.int/esalogo/images/logotype/img_colorlogo_darkblue.gif
[here]: https://nanosat-mo-framework.github.io/
[European Space Agency Public License - v2.0]: https://github.com/esa/CCSDS_MO_TRANS/blob/master/LICENCE.md
[GitHub]: https://github.com/esa
[Bug Reports]: https://github.com/esa/nanosat-mo-framework/issues
[website]: http://www.esa.int/
