package com.webtoeic.entities;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QBaiTapNghe extends EntityPathBase<BaiTapNghe> {

    private static final long serialVersionUID = -212964565L;

    public static final QBaiTapNghe baiTapNghe = new QBaiTapNghe("baiTapNghe");

    public final NumberPath<Integer> doKho = createNumber("doKho", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<CauHoiBaiTapNghe, QCauHoiBaiTapNghe> listCauHoiBaiTapNghe = this.<CauHoiBaiTapNghe, QCauHoiBaiTapNghe>createList("listCauHoiBaiTapNghe", CauHoiBaiTapNghe.class, QCauHoiBaiTapNghe.class, PathInits.DIRECT2);

    public final NumberPath<Integer> part = createNumber("part", Integer.class);

    public final StringPath script = createString("script");

    public final StringPath tenBaiNghe = createString("tenBaiNghe");


    public QBaiTapNghe(String variable) {
        super(BaiTapNghe.class, forVariable(variable));
    }

    public QBaiTapNghe(Path<? extends BaiTapNghe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaiTapNghe(PathMetadata metadata) {
        super(BaiTapNghe.class, metadata);
    }
}
