package io.nuls.db.dao.impl.mybatis.mapper;

import io.nuls.db.entity.UtxoInputPo;

public interface UtxoInputMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table utxo_input
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String hash);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table utxo_input
     *
     * @mbg.generated
     */
    int insert(UtxoInputPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table utxo_input
     *
     * @mbg.generated
     */
    int insertSelective(UtxoInputPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table utxo_input
     *
     * @mbg.generated
     */
    UtxoInputPo selectByPrimaryKey(String hash);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table utxo_input
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UtxoInputPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table utxo_input
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(UtxoInputPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table utxo_input
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UtxoInputPo record);
}