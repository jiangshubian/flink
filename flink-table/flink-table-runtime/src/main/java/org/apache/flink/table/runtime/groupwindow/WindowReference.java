/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.runtime.groupwindow;

import org.apache.flink.annotation.Internal;
import org.apache.flink.table.types.logical.LogicalType;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nullable;

import java.util.Objects;
import java.util.Optional;

/**
 * Indicate timeField type.
 *
 * @deprecated The POJOs in this package are used to represent the deprecated Group Window feature.
 *     Currently, they are also used to configure Python operators.
 */
@Deprecated
@Internal
public class WindowReference {

    public static final String FIELD_NAME_NAME = "name";
    public static final String FIELD_NAME_TYPE = "type";

    @JsonProperty(FIELD_NAME_NAME)
    private final String name;

    @JsonProperty(FIELD_NAME_TYPE)
    private final @Nullable LogicalType type;

    @JsonCreator
    public WindowReference(
            @JsonProperty(FIELD_NAME_NAME) String name,
            @JsonProperty(FIELD_NAME_TYPE) @Nullable LogicalType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public Optional<LogicalType> getType() {
        return Optional.ofNullable(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WindowReference that = (WindowReference) o;
        return Objects.equals(name, that.name) && Objects.equals(type, that.type);
    }

    @Override
    public String toString() {
        return "'" + name;
    }
}
