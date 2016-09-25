[![Build Status](https://travis-ci.org/rajasekharb/learn-hibernate.svg?branch=master)](https://travis-ci.org/rajasekharb/learn-hibernate)
[![Coverage Status](https://coveralls.io/repos/github/rajasekharb/learn-hibernate/badge.svg?branch=master)](https://coveralls.io/github/rajasekharb/learn-hibernate?branch=master)
## Hibernate for Beginners

---
### Hibernate version 5.2.2.Final Quickstart Samples
___

1. Helps to get started with the new StandardServiceRegistryBuilder and MetadataSources API to bootstrap hibernate.
2. HibernateUtils.java can be used in any other projects. Simply copy and paste
3. Uses annotations as well as xml based mappings. Uses standard hibernate.cfg.xml
4. Creation/Insertion of todo table
5. Hibernate one to many example with list, set, array, map, bag, idbag
6. Provides options to work with oracle and hsqldb(In memory)

---
#### Troubleshooting

* The file pom.xml has oracle dependency 
* Download the oracle jar for 11g and install with the same groupId, artifactId and version into your local machine
* Oracle jdbc driver jar from the pom.xml has to be commented if you don't want to work with oracle as the database

---

#### Reference:
* Used the concepts and examples from "Just Hibernate" book by Madhusudhan Konda
