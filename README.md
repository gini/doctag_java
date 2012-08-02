docTag Java Library
===================

The docTag Java library provides classes and domain objects used for reading and writing docTag meta data in
various document formats.

Connectors
----------

Connector are used to process data in a specific format and handle reading and writing docTag meta data from and to
these data formats. Typically there's one connector for each kind of file format supported.


Specification
-------------

The public docTag specification will be published soon and this README will be updated.


Tests
-----

[![Build Status](https://secure.travis-ci.org/smarchive/doctag_java.png?branch=master)](http://travis-ci.org/smarchive/doctag_java)

This library aims to have a comprehensive test suite which is being run after each push to the repository by
Travis CI (see badge above).

To run the tests locally you need Java 6 or higher and Maven 3. To install the dependencies and run all tests just
enter the following command in the root directory of the repository:

    mvn test


License
-------

This library is released under the [Apache License version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt).
