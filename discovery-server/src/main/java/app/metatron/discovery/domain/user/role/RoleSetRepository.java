/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.metatron.discovery.domain.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

/**
 * Created by kyungtaak on 2016. 1. 7..
 */
@RepositoryRestResource(path = "rolesets", itemResourceRel = "roleSet", collectionResourceRel = "roleSets",
    excerptProjection = RoleSetProjections.DefaultRoleProjection.class)
public interface RoleSetRepository extends JpaRepository<RoleSet, String>, QueryDslPredicateExecutor<RoleSet> {

  RoleSet findByName(String name);

  @Query("SELECT distinct p.name " +
      "FROM RoleSet rs INNER JOIN rs.roles r INNER JOIN r.permissions p " +
      "WHERE rs IN :roleSets AND r.name IN :roleNames")
  Set<String> getPermissionsByRoleSetAndRoleName(@Param("roleSets") List<RoleSet> roleSets,
                                                 @Param("roleNames") List<String> roleNames);

}
