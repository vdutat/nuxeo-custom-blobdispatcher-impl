# nuxeo-custom-blobdispatcher-impl

## About / Synopsis

This plugin demonstrates how to contribute a custom java implementation to be used by the **blob displatcher** that allows the use of system property `ecm:currentLifeCycleState` in the **blob dispatcher**'s rules. E.g.:
```
  <extension target="org.nuxeo.ecm.core.blob.DocumentBlobManager" point="configuration">
    <blobdispatcher>
      <class>com.acme.ecm.core.blob.CustomBlobDispatcher</class>
      <property name="ecm:currentLifeCycleState=obsolete">obsolete</property>
      <property name="default">default</property>
    </blobdispatcher>
  </extension>
```
OOTB the use of system property `ecm:currentLifeCycleState` in the **blob dispatcher**'s rules is not supported.

This plugin was generated with the following commands:
```
mkdir nuxeo-custom-blobdispatcher-impl && cd $_
nuxeo b multi-module
nuxeo b contribution --type core
# Edit java class
mvn clean install -T6 -s ~/.m2/settings-nuxeo-plugin.xml

nuxeo b package
mvn clean install -T6 -s ~/.m2/settings-nuxeo-plugin.xml
```

## Requirements

Building requires the following software:

* git
* maven

## Build

```
git clone ...
cd nuxeo-custom-blobdispatcher-impl

mvn clean install
```

## Installation

```
nuxeoctl mp-install nuxeo-custom-blobdispatcher-impl/nuxeo-custom-blobdispatcher-impl-package/target/nuxeo-custom-blobdispatcher-impl-*.zip
```

## Build and run with Docker and Docker Compose

### Requirements

* maven

### Build

```
mvn clean install
```

## Support

**These features are not part of the Nuxeo Production platform, they are not supported**

These solutions are provided for inspiration and we encourage customers to use them as code samples and learning resources.

This is a moving project (no API maintenance, no deprecation process, etc.) If any of these solutions are found to be useful for the Nuxeo Platform in general, they will be integrated directly into platform, not maintained here.


## License

[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

## About Nuxeo

Nuxeo Platform is an open source Content Services platform, written in Java. Data can be stored in both SQL & NoSQL databases.

The development of the Nuxeo Platform is mostly done by Nuxeo employees with an open development model.

The source code, documentation, roadmap, issue tracker, testing, benchmarks are all public.

Typically, Nuxeo users build different types of information management solutions for [document management](https://www.nuxeo.com/solutions/document-management/), [case management](https://www.nuxeo.com/solutions/case-management/), and [digital asset management](https://www.nuxeo.com/solutions/dam-digital-asset-management/), use cases. It uses schema-flexible metadata & content models that allows content to be repurposed to fulfill future use cases.

More information is available at [www.nuxeo.com](https://www.nuxeo.com).

