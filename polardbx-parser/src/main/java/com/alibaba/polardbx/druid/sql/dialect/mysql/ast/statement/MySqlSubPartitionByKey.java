/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
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
package com.alibaba.polardbx.druid.sql.dialect.mysql.ast.statement;

import com.alibaba.polardbx.druid.sql.ast.SQLExpr;
import com.alibaba.polardbx.druid.sql.ast.SQLName;
import com.alibaba.polardbx.druid.sql.ast.SQLSubPartitionBy;
import com.alibaba.polardbx.druid.sql.dialect.mysql.ast.MySqlObject;
import com.alibaba.polardbx.druid.sql.dialect.mysql.visitor.MySqlASTVisitor;
import com.alibaba.polardbx.druid.sql.visitor.SQLASTVisitor;

public class MySqlSubPartitionByKey extends SQLSubPartitionBy implements MySqlObject {
    private int algorithm = 2;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof MySqlASTVisitor) {
            accept0((MySqlASTVisitor) visitor);
        } else {
            throw new IllegalArgumentException("not support visitor type : " + visitor.getClass().getName());
        }
    }

    @Override
    public void accept0(MySqlASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, columns);
            acceptChild(visitor, subPartitionsCount);
        }
        visitor.endVisit(this);
    }

    public void addColumn(SQLName column) {
        if (column != null) {
            column.setParent(this);
        }
        this.columns.add(column);
    }

    public void cloneTo(MySqlSubPartitionByKey x) {
        super.cloneTo(x);
        for (SQLExpr column : columns) {
            SQLExpr c2 = column.clone();
            c2.setParent(x);
            x.columns.add(c2);
        }
        x.algorithm = algorithm;
    }

    public MySqlSubPartitionByKey clone() {
        MySqlSubPartitionByKey x = new MySqlSubPartitionByKey();
        cloneTo(x);
        return x;
    }

    public int getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(int algorithm) {
        this.algorithm = algorithm;
    }

    public boolean isPartitionByColumn(long columnNameHashCode64) {
        for (SQLExpr column : columns) {
            if (column.hashCode() == columnNameHashCode64) {
                return true;
            }
        }
        return false;
    }
}
