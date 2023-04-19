package com.webtoeic.entities;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QBaiTapDoc extends EntityPathBase<BaiTapDoc> {

    private static final long serialVersionUID = 2071330787L;

    public static final QBaiTapDoc baiTapDoc = new QBaiTapDoc("baiTapDoc");

    public final NumberPath<Integer> doKho = createNumber("doKho", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<CauHoiBaiTapDoc, QCauHoiBaiTapDoc> listCauHoiBaiTapDoc = this.<CauHoiBaiTapDoc, QCauHoiBaiTapDoc>createList("listCauHoiBaiTapDoc", CauHoiBaiTapDoc.class, QCauHoiBaiTapDoc.class, PathInits.DIRECT2);

    public final NumberPath<Integer> part = createNumber("part", Integer.class);

    public final StringPath script = createString("script");

    public final StringPath tenBaiDoc = createString("tenBaiDoc");

    public QBaiTapDoc(String variable) {

        super(BaiTapDoc.class, forVariable(variable));
    }

    public QBaiTapDoc(Path<? extends BaiTapDoc> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaiTapDoc(PathMetadata metadata) {
        super(BaiTapDoc.class, metadata);
    }
}
