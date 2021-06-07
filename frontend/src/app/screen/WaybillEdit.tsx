import * as React from "react";
import { Form, Alert, Button, Card, message } from "antd";
import { FormInstance } from "antd/es/form";
import { observer } from "mobx-react";
import { WaybillManagement } from "./WaybillManagement";
import { Link, Redirect } from "react-router-dom";
import {
  IReactionDisposer,
  observable,
  reaction,
  toJS,
  makeObservable
} from "mobx";
import {
  FormattedMessage,
  injectIntl,
  WrappedComponentProps
} from "react-intl";
import {
  defaultHandleFinish,
  createAntdFormValidationMessages
} from "@haulmont/jmix-react-ui";

import {
  loadAssociationOptions,
  DataCollectionStore,
  instance,
  MainStoreInjected,
  injectMainStore
} from "@haulmont/jmix-react-core";

import { Field, MultilineText, Spinner } from "@haulmont/jmix-react-ui";

import "../../app/App.css";

import { Waybill } from "../../jmix/entities/Waybill";
import { User } from "../../jmix/entities/st_User";
import { Customer } from "../../jmix/entities/Customer";
import { Spaceport } from "../../jmix/entities/Spaceport";
import { Carrier } from "../../jmix/entities/Carrier";

type Props = EditorProps & MainStoreInjected;

type EditorProps = {
  entityId: string;
};

class WaybillEditComponent extends React.Component<
  Props & WrappedComponentProps
> {
  dataInstance = instance<Waybill>(Waybill.NAME, {
    view: "waybill-fetch-plan",
    loadImmediately: false
  });

  creatorsDc: DataCollectionStore<User> | null = null;

  shippersDc: DataCollectionStore<Customer> | null = null;

  consigneesDc: DataCollectionStore<Customer> | null = null;

  departurePortsDc: DataCollectionStore<Spaceport> | null = null;

  destinationPortsDc: DataCollectionStore<Spaceport> | null = null;

  carriersDc: DataCollectionStore<Carrier> | null = null;

  updated = false;
  formRef: React.RefObject<FormInstance> = React.createRef();
  reactionDisposers: IReactionDisposer[] = [];

  fields = [
    "reference",
    "totalWeight",
    "totalCharge",
    "creator",
    "shipper",
    "consignee",
    "departurePort",
    "destinationPort",
    "carrier",
    "items"
  ];

  globalErrors: string[] = [];

  /**
   * This method should be called after the user permissions has been loaded
   */
  loadAssociationOptions = () => {
    // MainStore should exist at this point
    if (this.props.mainStore != null) {
      const { getAttributePermission } = this.props.mainStore.security;

      this.creatorsDc =
        loadAssociationOptions(
          Waybill.NAME,
          "creator",
          User.NAME,
          getAttributePermission,
          { view: "_instance_name" }
        ) ?? null;

      this.shippersDc =
        loadAssociationOptions(
          Waybill.NAME,
          "shipper",
          Customer.NAME,
          getAttributePermission,
          { view: "_instance_name" }
        ) ?? null;

      this.consigneesDc =
        loadAssociationOptions(
          Waybill.NAME,
          "consignee",
          Customer.NAME,
          getAttributePermission,
          { view: "_instance_name" }
        ) ?? null;

      this.departurePortsDc =
        loadAssociationOptions(
          Waybill.NAME,
          "departurePort",
          Spaceport.NAME,
          getAttributePermission,
          { view: "_instance_name" }
        ) ?? null;

      this.destinationPortsDc =
        loadAssociationOptions(
          Waybill.NAME,
          "destinationPort",
          Spaceport.NAME,
          getAttributePermission,
          { view: "_instance_name" }
        ) ?? null;

      this.carriersDc =
        loadAssociationOptions(
          Waybill.NAME,
          "carrier",
          Carrier.NAME,
          getAttributePermission,
          { view: "_instance_name" }
        ) ?? null;
    }
  };

  handleFinishFailed = () => {
    const { intl } = this.props;
    message.error(
      intl.formatMessage({ id: "management.editor.validationError" })
    );
  };

  handleFinish = (values: { [field: string]: any }) => {
    const { intl } = this.props;

    if (this.formRef.current != null) {
      defaultHandleFinish(
        values,
        this.dataInstance,
        intl,
        this.formRef.current,
        this.isNewEntity() ? "create" : "edit"
      ).then(({ success, globalErrors }) => {
        if (success) {
          this.updated = true;
        } else {
          this.globalErrors = globalErrors;
        }
      });
    }
  };

  isNewEntity = () => {
    return this.props.entityId === WaybillManagement.NEW_SUBPATH;
  };

  constructor(props: Props & WrappedComponentProps) {
    super(props);

    makeObservable(this, {
      creatorsDc: observable,

      shippersDc: observable,

      consigneesDc: observable,

      departurePortsDc: observable,

      destinationPortsDc: observable,

      carriersDc: observable,

      updated: observable,
      formRef: observable,
      globalErrors: observable
    });
  }

  render() {
    if (this.updated) {
      return <Redirect to={WaybillManagement.PATH} />;
    }

    const { status, lastError, load } = this.dataInstance;
    const { mainStore, entityId, intl } = this.props;
    if (mainStore == null || !mainStore.isEntityDataLoaded()) {
      return <Spinner />;
    }

    // do not stop on "COMMIT_ERROR" - it could be bean validation, so we should show fields with errors
    if (status === "ERROR" && lastError === "LOAD_ERROR") {
      return (
        <>
          <FormattedMessage id="common.requestFailed" />.
          <br />
          <br />
          <Button htmlType="button" onClick={() => load(entityId)}>
            <FormattedMessage id="common.retry" />
          </Button>
        </>
      );
    }

    return (
      <Card className="narrow-layout">
        <Form
          onFinish={this.handleFinish}
          onFinishFailed={this.handleFinishFailed}
          layout="vertical"
          ref={this.formRef}
          validateMessages={createAntdFormValidationMessages(intl)}
        >
          <Field
            entityName={Waybill.NAME}
            propertyName="reference"
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="totalWeight"
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="totalCharge"
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="creator"
            optionsContainer={this.creatorsDc ?? undefined}
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="shipper"
            optionsContainer={this.shippersDc ?? undefined}
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="consignee"
            optionsContainer={this.consigneesDc ?? undefined}
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="departurePort"
            optionsContainer={this.departurePortsDc ?? undefined}
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="destinationPort"
            optionsContainer={this.destinationPortsDc ?? undefined}
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="carrier"
            optionsContainer={this.carriersDc ?? undefined}
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          <Field
            entityName={Waybill.NAME}
            propertyName="items"
            nestedEntityView="_base"
            parentEntityInstanceId={
              this.props.entityId !== WaybillManagement.NEW_SUBPATH
                ? this.props.entityId
                : undefined
            }
            formItemProps={{
              style: { marginBottom: "12px" }
            }}
          />

          {this.globalErrors.length > 0 && (
            <Alert
              message={<MultilineText lines={toJS(this.globalErrors)} />}
              type="error"
              style={{ marginBottom: "24px" }}
            />
          )}

          <Form.Item style={{ textAlign: "center" }}>
            <Link to={WaybillManagement.PATH}>
              <Button htmlType="button">
                <FormattedMessage id="common.cancel" />
              </Button>
            </Link>
            <Button
              type="primary"
              htmlType="submit"
              disabled={status !== "DONE" && status !== "ERROR"}
              loading={status === "LOADING"}
              style={{ marginLeft: "8px" }}
            >
              <FormattedMessage id="common.submit" />
            </Button>
          </Form.Item>
        </Form>
      </Card>
    );
  }

  componentDidMount() {
    if (this.isNewEntity()) {
      this.dataInstance.setItem(new Waybill());
    } else {
      this.dataInstance.load(this.props.entityId);
    }

    this.reactionDisposers.push(
      reaction(
        () => this.dataInstance.status,
        () => {
          const { intl } = this.props;
          if (
            this.dataInstance.lastError != null &&
            this.dataInstance.lastError !== "COMMIT_ERROR"
          ) {
            message.error(intl.formatMessage({ id: "common.requestFailed" }));
          }
        }
      )
    );

    this.reactionDisposers.push(
      reaction(
        () => this.props.mainStore?.security.isDataLoaded,
        (isDataLoaded, _prevIsDataLoaded, permsReaction) => {
          if (isDataLoaded === true) {
            // User permissions has been loaded.
            // We can now load association options.
            this.loadAssociationOptions(); // Calls REST API
            permsReaction.dispose();
          }
        },
        { fireImmediately: true }
      )
    );

    this.reactionDisposers.push(
      reaction(
        () => this.formRef.current,
        (formRefCurrent, _prevFormRefCurrent, formRefReaction) => {
          if (formRefCurrent != null) {
            // The Form has been successfully created.
            // It is now safe to set values on Form fields.
            this.reactionDisposers.push(
              reaction(
                () => this.dataInstance.item,
                () => {
                  formRefCurrent.setFieldsValue(
                    this.dataInstance.getFieldValues(this.fields)
                  );
                },
                { fireImmediately: true }
              )
            );
            formRefReaction.dispose();
          }
        },
        { fireImmediately: true }
      )
    );
  }

  componentWillUnmount() {
    this.reactionDisposers.forEach(dispose => dispose());
  }
}

export default injectIntl(injectMainStore(observer(WaybillEditComponent)));
