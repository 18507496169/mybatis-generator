README
===========
1. 该工具根据数据库表名一键生成DO、DAO、mapper.xml文件，生成的文件直接存入当前工程指定的包下，目前只支持MySQL
2. 实现上并没有集成MyBatis Generator，而是采用Freemarker生成代码，更加轻量，更容易定制SQL语句和命名风格
3. 使用工具的价值在于减少人为工作量，统一代码风格


### Quick start
1. build.gradle中引入jar包依赖 
    ```
    testCompile('cn.com.duiba.shark:mybatis-generator:0.1.0')
    ```
2. 在test目录下新建CodeGenerator.java，代码如下：
    ```java
    public class CodeGenerator {

       public static void main(String[] args) {
            //数据库的连接信息、用户名、密码
            String DB_URL = "jdbc:mysql://dev.config.duibar.com:3306/tuia_media?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&connectTimeout=5000&socketTimeout=60000";
            String user = "dev";
            String pwd = "dev_fas015";
    
            GeneratorConfig config = new GeneratorConfig(DB_URL, user, pwd);
            //设置生成的 XXXXMapper.java所在的包名
            config.setDaoPackage("cn.com.duiba.tuia.ssp.center.biz.dao.ssp");
            //设置生成的 XXXXDO.java所在的包名
            config.setDOpackage("cn.com.duiba.tuia.ssp.center.biz.dao");
            //设置生成的XXX.java存放的模块名
            config.setModuleName("ssp-center-biz");
            //设置生成的XXXXMapper.xml存在的相对路径，相对工程根目录，
            config.setXmlLocation("ssp-center-deploy/src/main/resources/mybatis");
            //设置数据库名，库名填错会找不到表
            config.setTableCatalog("tuia_media");
            //设置表名，生成器根据设置的表生成代码
            config.setTableName("tb_activity");
            //设置数据表前缀，比如tb_activity的前缀为tb，设置了此项之后生成的do、dao、mapper.xml不包含前缀tb
            config.setTablePrefix("tb");
    
            //代码生成
            MybatisGenerator.genCode(config);
        }
    }
    ```
3. 执行main方法，如果没有报任何错误，则生成了表对应的do、dao、mapper.xml文件。在第一次使用时，需要做以上的准备工作，
之后就只需要修改数据库表名称即可。


### 生成的代码说明 
1. 生成的do命名为**表名称DO.java**，dao命名为**表名称Mapper.java**，xml文件命名为**表名称Mapper.xml**
2. 生成的SQL语句有以下几种类型：
    - 插入：命名为save
    - 删除：根据主键单条删除 deleteById 、根据一堆主键批量删除, deleteBatchByIds
    - 修改：updateById
    - 查询：
        - 根据主键单条查询 getById
        - 根据一堆主键批量查询 listByIds
        - 根据唯一键单条查询，查询的名称： getBy+唯一键名称
        - 根据一堆唯一键批量查询 listBy+唯一键名称
        - 根据传入的参数分页查询 listByParam 传入的参数是map
        - 根据传入的参数count计算 countByParam 
        
        
### 代码示例
以下代码根据上面的Quick start生成
1. 生成的DO文件

    ```java
    package cn.com.duiba.tuia.ssp.center.biz.dao;
    
    import java.io.Serializable;
    import java.util.Date;
    
    /**
    * 活动表
    */
    public class ActivityDO implements Serializable {
    
        private static final long serialVersionUID = 1L;
    
        private Long id;
    
        /**
        * 活动ID
        */
        private Long activityId;
    
        /**
        * 活动名称
        */
        private String activityName;
    
        /**
        * 活动类型
        */
        private Integer activityType;
    
        /**
        * 活动状态
        */
        private Integer activityStatus;
    
        /**
        * 是否删除 1：删除 0：未删除
        */
        private Integer isDelete;
    
        /**
        * 活动标签
        */
        private String tag;
    
        /**
        * 创建时间
        */
        private Date gmtCreate;
    
        /**
        * 修改时间
        */
        private Date gmtModified;
    
        /**
        * 是否定向媒体 0不定向 1定向
        */
        private Integer isDirectMedia;
    
        /**
        * 是否定向广告券 0未定向1定向
        */
        private Integer isDirectAdvert;
    
        /**
        * 0仅投放定制广告列表，1优先投放定制广告券列表
        */
        private Integer directAdvertMode;
    
        /**
        * 是否发布 0未发布，1已发布
        */
        private Integer isPublish;
    
        /**
        * 活动是否开启 0不开启1开启
        */
        private Integer isEnable;
    
        /**
        * 活动关联规格ID列表
        */
        private String activityMsList;
    
        /**
        * 是否为新活动 1：新活动；0：旧活动（曝光量<2000定义为新活动）
        */
        private Integer isNewAct;
    
        /**
        * 活动来源 0-兑吧活动 1-推啊活动
        */
        private Integer source;
    
        /**
        * 推广计划描述
        */
        private String description;
    
        /**
        * 推广计划标题
        */
        private String planTitle;
    
        /**
        * 活动皮肤类型
        */
        private String subType;
    
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setActivityId(Long activityId) {
            this.activityId = activityId;
        }
    
        public Long getActivityId() {
            return activityId;
        }
    
        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }
    
        public String getActivityName() {
            return activityName;
        }
    
        public void setActivityType(Integer activityType) {
            this.activityType = activityType;
        }
    
        public Integer getActivityType() {
            return activityType;
        }
    
        public void setActivityStatus(Integer activityStatus) {
            this.activityStatus = activityStatus;
        }
    
        public Integer getActivityStatus() {
            return activityStatus;
        }
    
        public void setIsDelete(Integer isDelete) {
            this.isDelete = isDelete;
        }
    
        public Integer getIsDelete() {
            return isDelete;
        }
    
        public void setTag(String tag) {
            this.tag = tag;
        }
    
        public String getTag() {
            return tag;
        }
    
        public void setGmtCreate(Date gmtCreate) {
            this.gmtCreate = gmtCreate;
        }
    
        public Date getGmtCreate() {
            return gmtCreate;
        }
    
        public void setGmtModified(Date gmtModified) {
            this.gmtModified = gmtModified;
        }
    
        public Date getGmtModified() {
            return gmtModified;
        }
    
        public void setIsDirectMedia(Integer isDirectMedia) {
            this.isDirectMedia = isDirectMedia;
        }
    
        public Integer getIsDirectMedia() {
            return isDirectMedia;
        }
    
        public void setIsDirectAdvert(Integer isDirectAdvert) {
            this.isDirectAdvert = isDirectAdvert;
        }
    
        public Integer getIsDirectAdvert() {
            return isDirectAdvert;
        }
    
        public void setDirectAdvertMode(Integer directAdvertMode) {
            this.directAdvertMode = directAdvertMode;
        }
    
        public Integer getDirectAdvertMode() {
            return directAdvertMode;
        }
    
        public void setIsPublish(Integer isPublish) {
            this.isPublish = isPublish;
        }
    
        public Integer getIsPublish() {
            return isPublish;
        }
    
        public void setIsEnable(Integer isEnable) {
            this.isEnable = isEnable;
        }
    
        public Integer getIsEnable() {
            return isEnable;
        }
    
        public void setActivityMsList(String activityMsList) {
            this.activityMsList = activityMsList;
        }
    
        public String getActivityMsList() {
            return activityMsList;
        }
    
        public void setIsNewAct(Integer isNewAct) {
            this.isNewAct = isNewAct;
        }
    
        public Integer getIsNewAct() {
            return isNewAct;
        }
    
        public void setSource(Integer source) {
            this.source = source;
        }
    
        public Integer getSource() {
            return source;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    
        public String getDescription() {
            return description;
        }
    
        public void setPlanTitle(String planTitle) {
            this.planTitle = planTitle;
        }
    
        public String getPlanTitle() {
            return planTitle;
        }
    
        public void setSubType(String subType) {
            this.subType = subType;
        }
    
        public String getSubType() {
            return subType;
        }
    
    }
    
    ```
    
2. 生成的DAO文件

    ```java
    package cn.com.duiba.tuia.ssp.center.biz.dao.ssp;
    
    import cn.com.duiba.tuia.ssp.center.biz.dao.ActivityDO;
    import java.util.List;
    import org.apache.ibatis.annotations.Param;
    import java.util.Map;
    
    public interface ActivityMapper {
    
        int save(ActivityDO activityDO);
    
        int deleteById(@Param("id")Long id);
    
        int deleteBatchById(@Param("ids")List<Long> ids);
    
        int updateById(ActivityDO activityDO);
    
        ActivityDO getById(@Param("id")Long id);
    
        List<ActivityDO> listById(@Param("ids")List<Long> ids);
    
        ActivityDO getByActivitySource(@Param("activityId")Long activityId,@Param("activityType")Integer activityType,@Param("source")Integer source);
    
        List<ActivityDO> listByActivitySource(@Param("activityIds")List<Long> activityIds,@Param("activityTypes")List<Integer> activityTypes,@Param("sources")List<Integer> sources);
    
        List<ActivityDO> listByParam(Map params);
    
        Integer countByParam(Map params);
    }
    ```
    
3. 生成的mapper.xml文件

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
    <mapper namespace="cn.com.duiba.tuia.ssp.center.biz.dao.ssp.ActivityMapper">
    
        <resultMap type="cn.com.duiba.tuia.ssp.center.biz.dao.ActivityDO" id="activityMap">
            <result property="id" column="id"/>
            <result property="activityId" column="activity_id"/>
            <result property="activityName" column="activity_name"/>
            <result property="activityType" column="activity_type"/>
            <result property="activityStatus" column="activity_status"/>
            <result property="isDelete" column="is_delete"/>
            <result property="tag" column="tag"/>
            <result property="gmtCreate" column="gmt_create"/>
            <result property="gmtModified" column="gmt_modified"/>
            <result property="isDirectMedia" column="is_direct_media"/>
            <result property="isDirectAdvert" column="is_direct_advert"/>
            <result property="directAdvertMode" column="direct_advert_mode"/>
            <result property="isPublish" column="is_publish"/>
            <result property="isEnable" column="is_enable"/>
            <result property="activityMsList" column="activity_ms_list"/>
            <result property="isNewAct" column="is_new_act"/>
            <result property="source" column="source"/>
            <result property="description" column="description"/>
            <result property="planTitle" column="plan_title"/>
            <result property="subType" column="sub_type"/>
        </resultMap>
    
        <sql id="columns"> id
            ,activity_id
            ,activity_name
            ,activity_type
            ,activity_status
            ,is_delete
            ,tag
            ,gmt_create
            ,gmt_modified
            ,is_direct_media
            ,is_direct_advert
            ,direct_advert_mode
            ,is_publish
            ,is_enable
            ,activity_ms_list
            ,is_new_act
            ,source
            ,description
            ,plan_title
            ,sub_type </sql>
    
        <insert id="save" useGeneratedKeys="true" keyProperty="id"
                parameterType="cn.com.duiba.tuia.ssp.center.biz.dao.ActivityDO">
            INSERT INTO tuia_media.tb_activity(activity_id,activity_name,activity_type,activity_status,is_delete,tag,is_direct_media,is_direct_advert,direct_advert_mode,is_publish,is_enable,activity_ms_list,is_new_act,source,description,plan_title,sub_type)
            VALUES(#{activityId},#{activityName},#{activityType},#{activityStatus},#{isDelete},#{tag},#{isDirectMedia},#{isDirectAdvert},#{directAdvertMode},#{isPublish},#{isEnable},#{activityMsList},#{isNewAct},#{source},#{description},#{planTitle},#{subType})
        </insert>
    
        <delete id="deleteById">
            DELETE FROM tuia_media.tb_activity WHERE id=#{id}
        </delete>
    
        <delete id="deleteBatchById">
            DELETE FROM tuia_media.tb_activity WHERE id IN
            <foreach item="item" index="index" collection="ids" open="("
                     separator="," close=")">
            #{item}
            </foreach>
        </delete>
    
        <update id="updateById" parameterType="cn.com.duiba.tuia.ssp.center.biz.dao.ActivityDO">
            UPDATE tuia_media.tb_activity
            <set>
                <if test="activityId != null">
                    activity_id = #{activityId},
                </if>
                <if test="activityName != null">
                    activity_name = #{activityName},
                </if>
                <if test="activityType != null">
                    activity_type = #{activityType},
                </if>
                <if test="activityStatus != null">
                    activity_status = #{activityStatus},
                </if>
                <if test="isDelete != null">
                    is_delete = #{isDelete},
                </if>
                <if test="tag != null">
                    tag = #{tag},
                </if>
                <if test="isDirectMedia != null">
                    is_direct_media = #{isDirectMedia},
                </if>
                <if test="isDirectAdvert != null">
                    is_direct_advert = #{isDirectAdvert},
                </if>
                <if test="directAdvertMode != null">
                    direct_advert_mode = #{directAdvertMode},
                </if>
                <if test="isPublish != null">
                    is_publish = #{isPublish},
                </if>
                <if test="isEnable != null">
                    is_enable = #{isEnable},
                </if>
                <if test="activityMsList != null">
                    activity_ms_list = #{activityMsList},
                </if>
                <if test="isNewAct != null">
                    is_new_act = #{isNewAct},
                </if>
                <if test="source != null">
                    source = #{source},
                </if>
                <if test="description != null">
                    description = #{description},
                </if>
                <if test="planTitle != null">
                    plan_title = #{planTitle},
                </if>
                <if test="subType != null">
                    sub_type = #{subType},
                </if>
            </set>
            WHERE id=#{id}
        </update>
    
        <select id="getById" resultMap="activityMap">
            SELECT <include refid="columns"/>
            FROM tuia_media.tb_activity
            WHERE id = #{id}
        </select>
    
        <select id="listById" resultMap="activityMap">
            SELECT <include refid="columns"/>
            FROM tuia_media.tb_activity
            WHERE id IN
            <foreach item="item" index="index" collection="ids" open="(" separator="," close=")">
                #{item}
            </foreach>
        </select>
    
    
        <select id="getByActivitySource" resultMap="activityMap">
            SELECT <include refid="columns"/>
            FROM tuia_media.tb_activity
            WHERE activity_id=#{activityId} and activity_type=#{activityType} and source=#{source}
        </select>
    
        <select id="listByActivitySource" resultMap="activityMap">
            SELECT <include refid="columns"/>
            FROM tuia_media.tb_activity
            WHERE
            activity_id IN
            <foreach item="item" index="index" collection="activityIds" open="(" separator="," close=")">
                #{item}
            </foreach>
             and activity_type IN
            <foreach item="item" index="index" collection="activityTypes" open="(" separator="," close=")">
                #{item}
            </foreach>
             and source IN
            <foreach item="item" index="index" collection="sources" open="(" separator="," close=")">
                #{item}
            </foreach>
            
        </select>
    
        <select id="listByParam" resultMap="activityMap" parameterType="java.util.Map">
            SELECT <include refid="columns"/>
            FROM tuia_media.tb_activity
            <where>
                <if test="activityId !=null">
                    AND activity_id = #{activityId}
                </if>
                <if test="activityName !=null">
                    AND activity_name = #{activityName}
                </if>
                <if test="activityType !=null">
                    AND activity_type = #{activityType}
                </if>
                <if test="activityStatus !=null">
                    AND activity_status = #{activityStatus}
                </if>
                <if test="isDelete !=null">
                    AND is_delete = #{isDelete}
                </if>
                <if test="tag !=null">
                    AND tag = #{tag}
                </if>
                <if test="isDirectMedia !=null">
                    AND is_direct_media = #{isDirectMedia}
                </if>
                <if test="isDirectAdvert !=null">
                    AND is_direct_advert = #{isDirectAdvert}
                </if>
                <if test="directAdvertMode !=null">
                    AND direct_advert_mode = #{directAdvertMode}
                </if>
                <if test="isPublish !=null">
                    AND is_publish = #{isPublish}
                </if>
                <if test="isEnable !=null">
                    AND is_enable = #{isEnable}
                </if>
                <if test="activityMsList !=null">
                    AND activity_ms_list = #{activityMsList}
                </if>
                <if test="isNewAct !=null">
                    AND is_new_act = #{isNewAct}
                </if>
                <if test="source !=null">
                    AND source = #{source}
                </if>
                <if test="description !=null">
                    AND description = #{description}
                </if>
                <if test="planTitle !=null">
                    AND plan_title = #{planTitle}
                </if>
                <if test="subType !=null">
                    AND sub_type = #{subType}
                </if>
            </where>
            <if test="offset != null and limit != null">
                limit #{offset}, #{limit}
            </if>
        </select>
    
        <select id="countByParam" resultType="java.lang.Integer" parameterType="java.util.Map">
            SELECT count(*)
            FROM tuia_media.tb_activity
            <where>
                <if test="activityId !=null">
                    AND activity_id = #{activityId}
                </if>
                <if test="activityName !=null">
                    AND activity_name = #{activityName}
                </if>
                <if test="activityType !=null">
                    AND activity_type = #{activityType}
                </if>
                <if test="activityStatus !=null">
                    AND activity_status = #{activityStatus}
                </if>
                <if test="isDelete !=null">
                    AND is_delete = #{isDelete}
                </if>
                <if test="tag !=null">
                    AND tag = #{tag}
                </if>
                <if test="isDirectMedia !=null">
                    AND is_direct_media = #{isDirectMedia}
                </if>
                <if test="isDirectAdvert !=null">
                    AND is_direct_advert = #{isDirectAdvert}
                </if>
                <if test="directAdvertMode !=null">
                    AND direct_advert_mode = #{directAdvertMode}
                </if>
                <if test="isPublish !=null">
                    AND is_publish = #{isPublish}
                </if>
                <if test="isEnable !=null">
                    AND is_enable = #{isEnable}
                </if>
                <if test="activityMsList !=null">
                    AND activity_ms_list = #{activityMsList}
                </if>
                <if test="isNewAct !=null">
                    AND is_new_act = #{isNewAct}
                </if>
                <if test="source !=null">
                    AND source = #{source}
                </if>
                <if test="description !=null">
                    AND description = #{description}
                </if>
                <if test="planTitle !=null">
                    AND plan_title = #{planTitle}
                </if>
                <if test="subType !=null">
                    AND sub_type = #{subType}
                </if>
            </where>
        </select>
    
    </mapper>
    ```
    

