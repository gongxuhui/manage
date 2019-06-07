package com.hsmt.action;

import org.apache.log4j.Logger;

import com.hsmt.service.EChartService;

public class EChartAction {
	Logger logger = Logger.getLogger("EChartAction");
	private int dataIndex;// ��������
	private EChartService eChartService;

	/* ��ȡ��״ͼ ����������Ϣ��json���� */
	public void getGroupData() {
		eChartService.getGroupJson();
	}

	/* ����dataIndex��ȡ��״ͼ ������Ա���ȼ� */
	public void getGroupLevelData() {
		eChartService.getGroupLevelJson(dataIndex);
		System.out.println(dataIndex);
		logger.info("action���л�ȡ��״ͼ��Ա���ȼ����õ�dataIndex-->" + dataIndex);

	};

	/* ��ȡ��״ͼ Ա��нˮ��Ϣ */
	public void getSalaryData() {
		eChartService.getSalaryJson();
		logger.info("action���л�ȡ��״ͼ��Ա��нˮ��Ϣ����");
	}

	/* ��ȡ��״ͼ ��Ʒ��Ϣ��json���� */
	public void getPieData() {
		eChartService.getPieData();
		logger.info("action���л�ȡ��״ͼ�Ĳ�Ʒ��Ϣ����");
	}

	/* ��ȡ��״ͼ ��������Ϣ��json���� */
	public void getIndentPieData() {
		eChartService.getIndentPieData();
		logger.info("action���л�ȡ��״ͼ��������Ϣ����");
	}

	/* ��ȡ��״ͼ ����������Ϣ��json���� */
	public void getAreaPieData() {
		eChartService.getAreaPieData(dataIndex);
		logger.info("action���л�ȡ��״ͼ����������Ϣ����");
	}

	/* ��ȡ����ͼ ӯ����Ϣ��json���� */
	public void getBarData() {
		eChartService.geBarData();
		logger.info("��ȡ����ͼ ӯ����Ϣ��json����");
	}

	public EChartService geteChartService() {
		return eChartService;
	}

	public void seteChartService(EChartService eChartService) {
		this.eChartService = eChartService;
	}

	public int getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(int dataIndex) {
		this.dataIndex = dataIndex;
	}

}
