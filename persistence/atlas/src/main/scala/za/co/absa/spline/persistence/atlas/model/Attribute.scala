/*
 * Copyright 2017 Barclays Africa Group Limited
 *
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

package za.co.absa.spline.persistence.atlas.model

import org.apache.atlas.AtlasClient
import org.apache.atlas.v1.model.instance.{Id, Referenceable}

/**
  * The class represents at attribute of a Spark data set.
  * @param name A name
  * @param qualifiedName An unique identifier
  * @param dataType A data type
  */
class Attribute(val name : String, val qualifiedName: String, dataType : DataType) extends Referenceable(
  SparkDataTypes.Attribute,
  new java.util.HashMap[String, Object]{
    put(AtlasClient.NAME, name)
    put(AtlasClient.REFERENCEABLE_ATTRIBUTE_NAME, qualifiedName.toString)
    put("type", dataType.name)
    put("typeRef", dataType)
  }
)
{
  /**
    * The method assigns dataset to the attribute
    * @param dataset An id of the assigned dataset
    */
  def assingDataset(dataset: Id) = set("dataset", dataset)
}