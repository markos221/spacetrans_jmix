import * as React from "react";
import { RouteComponentProps } from "react-router";
import { observer } from "mobx-react";
import WaybillItemEdit from "./WaybillItemEdit";
import WaybillItemList from "./WaybillItemList";
import { PaginationConfig } from "antd/es/pagination";
import { action, observable, makeObservable } from "mobx";
import {
  addPagingParams,
  createPagingConfig,
  defaultPagingConfig
} from "@haulmont/jmix-react-ui";

type Props = RouteComponentProps<{ entityId?: string }>;

class WaybillItem1ManagementComponent extends React.Component<Props> {
  static PATH = "/waybillItemManagement";
  static NEW_SUBPATH = "new";

  paginationConfig: PaginationConfig = { ...defaultPagingConfig };

  constructor(props: Props) {
    super(props);

    makeObservable(this, {
      paginationConfig: observable,
      onPagingChange: action
    });
  }

  componentDidMount(): void {
    // to disable paging config pass 'true' as disabled param in function below
    this.paginationConfig = createPagingConfig(this.props.location.search);
  }

  render() {
    const { entityId } = this.props.match.params;
    return entityId ? (
      <WaybillItemEdit entityId={entityId} />
    ) : (
      <WaybillItemList />
    );
  }

  onPagingChange = (current: number, pageSize: number) => {
    this.props.history.push(
      addPagingParams("waybillItemManagement", current, pageSize)
    );
    this.paginationConfig = { ...this.paginationConfig, current, pageSize };
  };
}

export const WaybillItemManagement = observer(WaybillItem1ManagementComponent);
