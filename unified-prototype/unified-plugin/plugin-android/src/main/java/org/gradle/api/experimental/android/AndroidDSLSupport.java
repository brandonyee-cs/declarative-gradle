/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.experimental.android;

import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.api.artifacts.VersionCatalog;
import org.gradle.api.artifacts.VersionCatalogsExtension;
import org.gradle.api.provider.Property;

public final class AndroidDSLSupport {
    private AndroidDSLSupport() { /* not instantiable */ }

    public static <T> void ifPresent(Property<T> property, Action<T> action) {
        if (property.isPresent()) {
            action.execute(property.get());
        }
    }

    public static VersionCatalog getLibs(Project project) {
        return project.getExtensions().getByType(VersionCatalogsExtension.class).find("libs").orElseThrow(IllegalStateException::new);
    }
}
