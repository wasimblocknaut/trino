/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.sql;

import io.airlift.configuration.Config;
import io.airlift.configuration.ConfigDescription;
import io.trino.spi.type.TimeZoneKey;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public class SqlEnvironmentConfig
{
    private Optional<String> path = Optional.empty();
    private Optional<String> defaultCatalog = Optional.empty();
    private Optional<String> defaultSchema = Optional.empty();
    private Optional<TimeZoneKey> forcedSessionTimeZone = Optional.empty();

    @NotNull
    public Optional<String> getPath()
    {
        return path;
    }

    @Config("sql.path")
    public SqlEnvironmentConfig setPath(String path)
    {
        this.path = Optional.ofNullable(path);
        return this;
    }

    @NotNull
    public Optional<String> getDefaultCatalog()
    {
        return defaultCatalog;
    }

    @Config("sql.default-catalog")
    public SqlEnvironmentConfig setDefaultCatalog(String catalog)
    {
        this.defaultCatalog = Optional.ofNullable(catalog);
        return this;
    }

    @NotNull
    public Optional<String> getDefaultSchema()
    {
        return defaultSchema;
    }

    @Config("sql.default-schema")
    public SqlEnvironmentConfig setDefaultSchema(String schema)
    {
        this.defaultSchema = Optional.ofNullable(schema);
        return this;
    }

    @NotNull
    public Optional<TimeZoneKey> getForcedSessionTimeZone()
    {
        return forcedSessionTimeZone;
    }

    @Config("sql.forced-session-time-zone")
    @ConfigDescription("User session time zone overriding value sent by client")
    public SqlEnvironmentConfig setForcedSessionTimeZone(@Nullable String timeZoneId)
    {
        this.forcedSessionTimeZone = Optional.ofNullable(timeZoneId)
                .map(TimeZoneKey::getTimeZoneKey);
        return this;
    }
}
