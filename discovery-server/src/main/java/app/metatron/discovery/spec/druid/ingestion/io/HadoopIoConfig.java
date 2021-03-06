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

package app.metatron.discovery.spec.druid.ingestion.io;

import javax.validation.constraints.NotNull;

import app.metatron.discovery.spec.druid.ingestion.input.InputSpec;

/**
 * Created by kyungtaak on 2016. 6. 17..
 */
public class HadoopIoConfig implements IoConfig {

  @NotNull
  InputSpec inputSpec;

  String segmentOutputPath;

  public HadoopIoConfig() {
  }

  public HadoopIoConfig(InputSpec inputSpec) {
    this.inputSpec = inputSpec;
  }

  public InputSpec getInputSpec() {
    return inputSpec;
  }

  public void setInputSpec(InputSpec inputSpec) {
    this.inputSpec = inputSpec;
  }

  public String getSegmentOutputPath() {
    return segmentOutputPath;
  }

  public void setSegmentOutputPath(String segmentOutputPath) {
    this.segmentOutputPath = segmentOutputPath;
  }

}
