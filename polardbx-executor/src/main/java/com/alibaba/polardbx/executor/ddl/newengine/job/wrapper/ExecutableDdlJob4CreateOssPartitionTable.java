/*
 * Copyright [2013-2021], Alibaba Group Holding Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.polardbx.executor.ddl.newengine.job.wrapper;

import com.alibaba.polardbx.executor.ddl.job.task.basic.CreatePartitionTableValidateTask;
import com.alibaba.polardbx.executor.ddl.job.task.basic.CreateTableAddTablesPartitionInfoMetaTask;
import com.alibaba.polardbx.executor.ddl.job.task.basic.CreateTablePhyDdlTask;
import com.alibaba.polardbx.executor.ddl.job.task.basic.CreateTableShowTableMetaTask;
import com.alibaba.polardbx.executor.ddl.job.task.basic.TableSyncTask;
import com.alibaba.polardbx.executor.ddl.job.task.basic.oss.BindingArchiveTableMetaTask;
import com.alibaba.polardbx.executor.ddl.job.task.basic.oss.CreateOssTableAddTablesMetaTask;
import com.alibaba.polardbx.executor.ddl.job.task.basic.oss.CreateOssTableFormatTask;
import com.alibaba.polardbx.executor.ddl.job.task.basic.oss.CreateOssTableGenerateDataTask;
import com.alibaba.polardbx.executor.ddl.newengine.job.ExecutableDdlJob;
import lombok.Data;

@Data
public class ExecutableDdlJob4CreateOssPartitionTable extends ExecutableDdlJob {

    private CreatePartitionTableValidateTask createPartitionTableValidateTask;
    private CreateTableAddTablesPartitionInfoMetaTask createTableAddTablesPartitionInfoMetaTask;
    private CreateTablePhyDdlTask createTablePhyDdlTask;
    private CreateOssTableAddTablesMetaTask createOssTableAddTablesMetaTask;
    private CreateOssTableFormatTask createOssTableFormatTask;
    private CreateOssTableGenerateDataTask createOssTableGenerateDataTask;
    private BindingArchiveTableMetaTask bindingArchiveTableMetaTask;
    private CreateTableShowTableMetaTask createTableShowTableMetaTask;
    private TableSyncTask tableSyncTask;

}
