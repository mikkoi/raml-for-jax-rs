/*
 * Copyright 2013-2017 (c) MuleSoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.raml.jaxrs.examples.resources;

import org.raml.jaxrs.common.Example;
import org.raml.pojotoraml.plugins.RamlGenerator;
import org.raml.jaxrs.examples.Secure;
import org.raml.jaxrs.handlers.SimpleJaxbClassParser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Jean-Philippe Belanger on 3/26/17. Just potential zeroes and ones:
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@RamlGenerator(parser = SimpleJaxbClassParser.class)
@Secure(security = String.class, level = 0)
public class ConsumedValue {

  @XmlElement
  @Example("foo")
  private String name;

  private int id;

  private SubType subType;

  private List<String> names;

  @Example("1")
  @Secure(security = String.class, level = 1)
  public int getId() {
    return id;
  }

  @Example("1")
  public SubType getSubType() {
    return subType;
  }

  @Example("['1','2','3']")
  public List<String> getNames() {
    return names;
  }
}
