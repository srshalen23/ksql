/**
 * Copyright 2017 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package io.confluent.ksql.function;

import org.apache.kafka.connect.data.Schema;

import java.util.List;
import java.util.Objects;

public class KsqlFunction {

  private final Schema returnType;
  private final List<Schema> arguments;
  private final String functionName;
  private final Class kudfClass;

  KsqlFunction(final Schema returnType,
               final List<Schema> arguments,
               final String functionName,
               final Class kudfClass) {
    Objects.requireNonNull(returnType, "returnType can't be null");
    Objects.requireNonNull(arguments, "arguments can't be null");
    Objects.requireNonNull(functionName, "functionName can't be null");
    Objects.requireNonNull(kudfClass, "kudfClass can't be null");
    this.returnType = returnType;
    this.arguments = arguments;
    this.functionName = functionName;
    this.kudfClass = kudfClass;
  }

  public Schema getReturnType() {
    return returnType;
  }

  public List<Schema> getArguments() {
    return arguments;
  }

  String getFunctionName() {
    return functionName;
  }


  public Class getKudfClass() {
    return kudfClass;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KsqlFunction that = (KsqlFunction) o;
    return Objects.equals(returnType, that.returnType)
        && Objects.equals(arguments, that.arguments)
        && Objects.equals(functionName, that.functionName)
        && Objects.equals(kudfClass, that.kudfClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(returnType, arguments, functionName, kudfClass);
  }
}
